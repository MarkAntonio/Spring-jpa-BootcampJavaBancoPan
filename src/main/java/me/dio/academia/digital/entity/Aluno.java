package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data  // cria get, set, equals e hashcode
@NoArgsConstructor  //serve para criar um  contrutor  vazio (o hibernate só funciona assim)
@AllArgsConstructor  // cria um construtor com todos os atributos da classe (nome, cpf, bairro, dataDeNascimento, avaliacoes)
@Entity // serve para dizer a classe que é uma entidade (uma table) para adicionar no banco de dados
@Table(name = "tb_alunos") //renomeia o nome da table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // coloquei por conta do FetchTye.Lazy (carregamento preguiçoso)
public class Aluno {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;

  @Column(unique = true)  // significa que o cpf não pode ser repetido
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento; // no banco de dados será salvo snake case (data_de_nascimento)


  // one to many vs many to many...
  @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE , fetch = FetchType.LAZY)
  //one (aluno) many(várias avaliações)                      o fetch = FetchType.LAZY é a forma de busca preguiçosa. Quer
          // dizer que quando eu pedir para ver as informações do aluno, a variável avaliações são será mostrada. Só será
          // mostrada quando eu chamar o método específico para exibi-la

  @JsonIgnore // ignora de me mostrar as exceções e serializações de algum erro
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
