public class IntegracaoNumerica {

    // Função para a integral da Regra dos Retângulos
    public static double regraDosRetangulos(double a, double b, int n) {
        double soma = 0;
        double deltaX = (b - a) / n;
        for (int i = 0; i < n; i++) {
            double x = a + i * deltaX;
            soma += Math.sqrt(Math.exp(x) + 1);
        }
        return soma * deltaX;
    }

    // Função para a integral da Regra dos Trapézios
    public static double regraDosTrapezios(double a, double b, int n) {
        double soma = (1 / (Math.exp(a) + 1) + 1 / (Math.exp(b) + 1)) / 2.0;
        double deltaX = (b - a) / n;
        for (int i = 1; i < n; i++) {
            double x = a + i * deltaX;
            soma += 1 / (Math.exp(x) + 1);
        }
        return soma * deltaX;
    }

    // Função para a integral da Regra de Simpson
    public static double regraDeSimpson(double a, double b, int n) {
        if (n % 2 != 0) n++; // Certificar que n é par
        double soma = Math.cos(a) * Math.sin(a) + Math.cos(b) * Math.sin(b);
        double deltaX = (b - a) / n;

        for (int i = 1; i < n; i++) {
            double x = a + i * deltaX;
            double fx = Math.cos(x) * Math.sin(x);
            soma += (i % 2 == 0) ? 2 * fx : 4 * fx;
        }

        return soma * deltaX / 3;
    }

    public static void main(String[] args) {
        int n = 1000; // Número de subintervalos

        // Regra dos Retângulos
        double integralRetangulos = regraDosRetangulos(0, 1, n);
        System.out.printf("Regra dos Retângulos: Integral ≈ %.6f\n", integralRetangulos);

        // Regra dos Trapézios
        double integralTrapezios = regraDosTrapezios(0, 1, n);
        System.out.printf("Regra dos Trapézios: Integral ≈ %.6f\n", integralTrapezios);

        // Regra de Simpson
        double integralSimpson = regraDeSimpson(0, Math.PI / 2, n);
        System.out.printf("Regra de Simpson: Integral ≈ %.6f\n", integralSimpson);

        // Cálculo do erro
        double resultadoAnaliticoRetangulos = 1.32; // Valor aproximado (ou calculado analiticamente)
        double erroRetangulos = Math.abs(integralRetangulos - resultadoAnaliticoRetangulos);
        System.out.printf("Erro (Retângulos): %.6f\n", erroRetangulos);

        double resultadoAnaliticoTrapezios = 0.804; // Valor aproximado (ou calculado analiticamente)
        double erroTrapezios = Math.abs(integralTrapezios - resultadoAnaliticoTrapezios);
        System.out.printf("Erro (Trapézios): %.6f\n", erroTrapezios);

        double resultadoAnaliticoSimpson = 0.5; // Valor aproximado (ou calculado analiticamente)
        double erroSimpson = Math.abs(integralSimpson - resultadoAnaliticoSimpson);
        System.out.printf("Erro (Simpson): %.6f\n", erroSimpson);
    }
}
