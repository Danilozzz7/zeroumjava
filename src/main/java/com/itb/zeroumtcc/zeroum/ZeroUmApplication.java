package com.zeroum.estagios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Plataforma de Estágios ZeroUm
 * Projeto de TCC desenvolvido por Danilo
 *
 * Esta é a classe principal que inicia a aplicação Spring Boot.
 * Certifique-se de que todos os pacotes estejam dentro de com.zeroum.estagios
 */
@SpringBootApplication
public class ZeroUmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZeroUmApplication.class, args);

		System.out.println("\n✅ ZeroUm Estágios iniciado com sucesso!");
		System.out.println("🔗 API REST disponível em: http://localhost:8080/api/v1");
		System.out.println("🗃️ Conectado ao banco de dados: bd_ZeroUm (SQL Server)");
		System.out.println("📦 Todos os componentes carregados: entidades, repositórios, controllers");
		System.out.println("👨‍🎓 Alunos, 👩‍💼 Empresas e 🧑‍💻 Vagas prontos para integração!\n");
	}
}