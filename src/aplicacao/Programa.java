package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogAcesso;

public class Programa {
	/*
	 * Problema exemplo
	 * Um site de internet registra um log de acessos dos usu�rios. 
	 * Um registro de log consiste no nome de usu�rio (apenas uma palavra) e o
	 * instante em que o usu�rio acessou o site no padr�o ISO 8601,
	 * separados por espa�o, conforme exemplo. Fazer um programa que leia
	 * o log de acessos a partir de um arquivo, e da� informe quantos usu�rios
	 * distintos acessaram o site.
	 */

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o caminho do arquivo ou zero para usar o padr�o:");
		String path = sc.nextLine();
		if(path.equals("0")) {
			path = "C:\\Users\\dsilva\\Documents\\logs-acesso.txt";
		}
		
		System.out.println(path);
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			//HashSet por conta de ser o mais r�pido e n�o importar a ordem dos logs
			Set<LogAcesso> set = new HashSet<>();
			
			//Leitura do arquivo
			String linha = br.readLine();
			
			while(linha != null) {
				String[] campos = linha.split(" ");
				String user = campos[0];
				Date moment = Date.from(Instant.parse(campos[1]));
				
				//se for adicionar algum usuario repetido n�o permitir�
				set.add(new LogAcesso(user, moment));
				
				linha = br.readLine();
			}
			
			System.out.println("Total de usu�rios: "+set.size());
			
		} catch (Exception e) {
			System.out.println("Erro "+ e.getMessage());
		}
		
		
		
		
		
		
		sc.close();
		

	}

}
