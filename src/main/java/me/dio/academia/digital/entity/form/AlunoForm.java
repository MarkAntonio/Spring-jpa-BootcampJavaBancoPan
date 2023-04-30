package me.dio.academia.digital.entity.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

    //  @NotEmpty(message = "Preencha o campo corretamente.")
    @NotBlank(message = "Preencha o campo corretamente.") // não pode ser vazio
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String nome;

    //  @NotEmpty(message = "Preencha o campo corretamente.")
    @NotBlank(message = "Preencha o campo corretamente.") // não pode ser vazio
    @CPF(message = "'${validatedValue}' é inválido!")
    private String cpf;

    //  @NotEmpty(message = "Preencha o campo corretamente.")
    @NotBlank(message = "Preencha o campo corretamente.") // não pode ser vazio
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
    private String bairro;

    @NotNull(message = "Prencha o campo corretamente.") // não pode ser nulo
    @Past(message = "Data '${validatedValue}' é inválida.") // indica que tem que ser sempre no passado
    // se eu colocar uma data acima de hoje ou hoje ele reclama
    private LocalDate dataDeNascimento;
}
