export const ROLE_CONFIG = {
    GUEST: ["quartos", "historico", "informacoes"],
    CLIENTE: ["quartos", "minhasMarcacoes", "historico", "informacoes"],
    STAFF: ["limpezas", "quartos", "historico", "informacoes"],
    RECEP: ["quartos", "marcacoes", "faturas", "clientes", "historico"],
    HR: ["quartos", "funcionarios", "historico"],
    GERENTE: ["*"],
    SUPERADMIN: ["*"]
};