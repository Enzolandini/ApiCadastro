package com.cadastro.Validacao;

public class Validacoes {

    public static boolean validarCpf(String cpf) {
        cpf = cpf.replace(".", "").replace("-", ""); // Remover pontuações
        if (cpf.length() != 11 || !cpf.matches("\\d{11}")) {
            return false; // O CPF deve ter exatamente 11 dígitos numéricos
        }

        // Métodos auxiliares
        if (todosDigitosIguais(cpf)) {
            return false;
        }

        int primeiroDigitoVerificador = calcularDigitoVerificador(cpf, 10);
        int segundoDigitoVerificador = calcularDigitoVerificador(cpf, 11);

        return cpf.charAt(9) == Character.forDigit(primeiroDigitoVerificador, 10) &&
               cpf.charAt(10) == Character.forDigit(segundoDigitoVerificador, 10);
    }

    private static boolean todosDigitosIguais(String cpf) {
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                return false;
            }
        }
        return true;
    }

    private static int calcularDigitoVerificador(String cpf, int pesoInicial) {
        int soma = 0;
        for (int i = 0; i < cpf.length() - 1; i++) {
            int digito = Character.getNumericValue(cpf.charAt(i));
            soma += digito * pesoInicial;
            pesoInicial--;
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : 11 - resto;
    }
    
    public static boolean validarEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(outlook\\.com|gmail\\.com|hotmail\\.com|[A-Za-z0-9+_.-]+\\.br)$";

        return email.matches(regex);
    }
    
    public static boolean validarCelular(String telefone) {
        String regex = "^\\d{2}\\d{9}$";

        return telefone.matches(regex);
    }


}
