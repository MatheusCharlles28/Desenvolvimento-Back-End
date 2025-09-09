package br.cadastro.model;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dadosalunolPU");
        EntityManager em = emf.createEntityManager();

        System.out.print("Digite o CEP para cadastro do endereço: ");
        String cepInformado = entrada.nextLine().replaceAll("\\D", "");

        Endereco enderecoEncontrado = null;

        List<Endereco> resultado = em.createQuery(
                        "SELECT e FROM Endereco e WHERE REPLACE(e.cep,'-','') = :cep", Endereco.class)
                .setParameter("cep", cepInformado)
                .getResultList();

        if (!resultado.isEmpty()) {
            enderecoEncontrado = resultado.get(0);
            System.out.println("Endereço localizado: " + enderecoEncontrado.getLogradouro()
                    + ", " + enderecoEncontrado.getBairro());
        } else {
            System.out.println("CEP não cadastrado. Buscando informações na ViaCEP...");
            enderecoEncontrado = viaCepCliente.buscarCep(cepInformado);

            if (enderecoEncontrado == null || enderecoEncontrado.getCep() == null) {
                System.out.println("CEP inválido ou não encontrado.");
                em.close();
                emf.close();
                entrada.close();
                return;
            }

            System.out.println("Novo endereço será registrado: "
                    + enderecoEncontrado.getLogradouro() + ", "
                    + enderecoEncontrado.getBairro() + ", "
                    + enderecoEncontrado.getLocalidade() + " - "
                    + enderecoEncontrado.getUf());
        }

        Aluno novoAluno = new Aluno();
        System.out.print("Nome do aluno: ");
        novoAluno.setNome(entrada.nextLine());

        System.out.print("CPF do aluno: ");
        novoAluno.setCpf(entrada.nextLine());

        System.out.print("Telefone: ");
        novoAluno.setTelefone(entrada.nextLine());

        System.out.print("E-mail: ");
        novoAluno.setEmail(entrada.nextLine());

        System.out.print("Número da residência: ");
        enderecoEncontrado.setNumero(Integer.parseInt(entrada.nextLine()));

        enderecoEncontrado.setAluno(novoAluno);
        novoAluno.getEnderecos().add(enderecoEncontrado);

        try {
            em.getTransaction().begin();
            em.persist(novoAluno);
            em.getTransaction().commit();
            System.out.println("Aluno registrado com sucesso! ID: " + novoAluno.getId());
        } catch (Exception ex) {
            em.getTransaction().rollback();
            System.out.println("Falha ao registrar aluno: " + ex.getMessage());
        } finally {
            em.close();
            emf.close();
            entrada.close();
        }
    }
}
