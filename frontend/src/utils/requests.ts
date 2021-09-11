export const BASE_URL = process.env.REACT_APP_BACKEND_URL ?? 'http://localhost:8080';
/*Caso a variável REACT_APP_BACKEND_URL não esteja definida no ambiente atual onde a aplicação está rodando
   * A url que vai ser utilizada será a de localhost
   * Dessa forma o projeto pode ser rodado tanto em ambiente local quanto em produção
*/