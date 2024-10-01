package br.com.mcc.petlov;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class Selenide {
    @Test
    @DisplayName("Deve poder cadastrar um ponto de doação")
    void cadastroTest() {
        // Login
        open("https://petlov.vercel.app/signup"); // inicia e fecha automaticamente a aplicação
        $("h1").shouldHave(text("Cadastro de ponto de doação"));

        // Inspecionar Elementos
        $("input[placeholder='Nome do ponto de doação']").setValue("Dog Point");
        $("input[name='email']").setValue("dog@point.com.br");
        $("input[name=cep]").setValue("04534011");
        $("input[value='Buscar CEP']").click();
        $("input[name='addressNumber']").setValue("17");
        $("input[name='addressDetails']").setValue("Loja ao lado da padaria");

        // Pets para adoção
        $(By.xpath("//span[text()=\"Cachorros\"]/..")).click();

        // Cadastrar
        $(".button-register").click();

        // Cadastro realizado com sucesso
        String target = "Seu ponto de doação foi adicionado com sucesso. Juntos, podemos criar um mundo onde todos os animais recebam o amor e cuidado que merecem.";

        $("#success-page p").shouldHave(text(target));
    }
}
