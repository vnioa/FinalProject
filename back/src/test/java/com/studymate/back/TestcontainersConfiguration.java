package com.studymate.back;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.chromadb.ChromaDBContainer;
import org.testcontainers.containers.CassandraContainer;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.Neo4jContainer;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.elasticsearch.ElasticsearchContainer;
import org.testcontainers.milvus.MilvusContainer;
import org.testcontainers.mongodb.MongoDBAtlasLocalContainer;
import org.testcontainers.ollama.OllamaContainer;
import org.testcontainers.oracle.OracleContainer;
import org.testcontainers.qdrant.QdrantContainer;
import org.testcontainers.utility.DockerImageName;
import org.testcontainers.weaviate.WeaviateContainer;

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

	@Bean
	@ServiceConnection
	CassandraContainer<?> cassandraContainer() {
		return new CassandraContainer<>(DockerImageName.parse("cassandra:latest"));
	}

	@Bean
	@ServiceConnection
	ChromaDBContainer chromaContainer() {
		return new ChromaDBContainer(DockerImageName.parse("chromadb/chroma:latest"));
	}

	@Bean
	@ServiceConnection
	ElasticsearchContainer elasticsearchContainer() {
		return new ElasticsearchContainer(DockerImageName.parse("docker.elastic.co/elasticsearch/elasticsearch:7.17.10"));
	}

	@Bean
	@ServiceConnection
	MariaDBContainer<?> mariaDbContainer() {
		return new MariaDBContainer<>(DockerImageName.parse("mariadb:latest"));
	}

	@Bean
	@ServiceConnection
	MilvusContainer milvusContainer() {
		return new MilvusContainer(DockerImageName.parse("milvusdb/milvus:latest"));
	}

	@Bean
	@ServiceConnection
	MongoDBContainer mongoDbContainer() {
		return new MongoDBContainer(DockerImageName.parse("mongo:latest"));
	}

	@Bean
	@ServiceConnection
	MongoDBAtlasLocalContainer mongoDbAtlasContainer() {
		return new MongoDBAtlasLocalContainer(DockerImageName.parse("mongodb/mongodb-atlas-local:latest"));
	}

	@Bean
	@ServiceConnection
	MySQLContainer<?> mysqlContainer() {
		return new MySQLContainer<>(DockerImageName.parse("mysql:latest"));
	}

	@Bean
	@ServiceConnection
	Neo4jContainer<?> neo4jContainer() {
		return new Neo4jContainer<>(DockerImageName.parse("neo4j:latest"));
	}

	@Bean
	@ServiceConnection
	OllamaContainer ollamaContainer() {
		return new OllamaContainer(DockerImageName.parse("ollama/ollama:latest"));
	}

	@Bean
	@ServiceConnection
	OracleContainer oracleFreeContainer() {
		return new OracleContainer(DockerImageName.parse("gvenzl/oracle-free:latest"));
	}

	@Bean
	@ServiceConnection
	PostgreSQLContainer<?> pgvectorContainer() {
		return new PostgreSQLContainer<>(DockerImageName.parse("pgvector/pgvector:pg16"));
	}

	@Bean
	@ServiceConnection
	QdrantContainer qdrantContainer() {
		return new QdrantContainer(DockerImageName.parse("qdrant/qdrant:latest"));
	}

	@Bean
	@ServiceConnection(name = "redis")
	GenericContainer<?> redisContainer() {
		return new GenericContainer<>(DockerImageName.parse("redis:latest")).withExposedPorts(6379);
	}

	@Bean
	@ServiceConnection(name = "redis")
	GenericContainer<?> redisStackContainer() {
		return new GenericContainer<>(DockerImageName.parse("redis/redis-stack:latest")).withExposedPorts(6379);
	}

	@Bean
	@ServiceConnection
	WeaviateContainer weaviateContainer() {
		return new WeaviateContainer(DockerImageName.parse("semitechnologies/weaviate:latest"));
	}

}
