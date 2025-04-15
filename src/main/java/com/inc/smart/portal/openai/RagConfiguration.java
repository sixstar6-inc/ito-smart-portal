package com.inc.smart.portal.openai;

import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.advisor.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Configuration;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


@Slf4j
@Configuration
public class RagConfiguration {

    private final static Logger logger = LoggerFactory.getLogger(RagConfiguration.class);

    @Value("vector_store.json")
    private String vectorStoreName;

    @Bean
    ChatClient chatClient(ChatClient.Builder builder, VectorStore vectorStore){
        var system = """
                DB INC 에는 ITO 지식 포털 서비스를 운영하고 있어. 프로젝트를 위한 다양한 산출물들이 등록되어 있지. 
                또한 문서 로드맵도 가지고 있어서 ITO 프로세스 저숙련자들을 위한 교육자료로도 사용할 수 있지.
                """;
        return builder
                .defaultSystem(system)
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    @Bean
    SimpleVectorStore simpleVectorStore(EmbeddingModel embeddingModel) throws IOException {
        var simpleVectorStore = SimpleVectorStore.builder(embeddingModel).build();
        var vectorStoreFile = getVectorStoreFile();
        if (vectorStoreFile.exists()) {
            logger.info("Vector Store File Exists,");
            simpleVectorStore.load(vectorStoreFile);
        } else {
            var doc1 = new VectorStoreDocument("a","수행계획서", "프로젝트를 시작하기 전에 작성하는 문서");
            Document document1 = new Document("id: %s, name: %s , description: %s".formatted(doc1.id(), doc1.name(), doc1.description()));
            simpleVectorStore.add(List.of(document1));

            var doc2 = new VectorStoreDocument("b","완료보고서", "프로젝트를 종료할때 작성하는 문서");
            Document document2 = new Document("id: %s, name: %s , description: %s".formatted(doc2.id(), doc2.name(), doc2.description()));
            simpleVectorStore.add(List.of(document2));

        }
        return simpleVectorStore;
    }

    private File getVectorStoreFile() {
        Path path = Paths.get("src", "main", "resources", "docs");
        String absolutePath = path.toFile().getAbsolutePath() + "/" + vectorStoreName;
        return new File(absolutePath);
    }

}
