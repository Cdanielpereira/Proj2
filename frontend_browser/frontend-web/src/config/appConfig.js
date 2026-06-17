export const appConfig = {

    GUEST: {
        homeTitle: "Bem-vindo!",
        allowedEntities: ["quarto", "informacoes"],
        menu: [
            { label: "Home", route: "/home", icon: "🏠" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ],
        homeActions: [
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ]
    },

    CLIENTE: {
        homeTitle: (u) => `Bem-vindo ${u.username}!`,
        allowedEntities: ["quarto", "marcacao", "historico", "informacoes"],
        menu: [
            { label: "Home", route: "/homeCliente", icon: "🏠" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Minhas Marcações", entity: "marcacao", icon: "📅" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ],
        homeActions: [
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Minhas Marcações", entity: "marcacao", icon: "📅" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ]
    },

    STAFF: {
        homeTitle: (u) => `Bem-vindo ${u.username}!`,
        allowedEntities: ["limpeza", "quarto", "piscina", "produto", "zona", "historico", "informacoes"],
        menu: [
            { label: "Home", route: "/homeUser", icon: "🏠" },
            { label: "Limpezas", entity: "limpeza", icon: "🧹" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Piscina", entity: "piscina", icon: "🏊" },
            { label: "Produtos", entity: "produto", icon: "📦" },
            { label: "Zonas", entity: "zona", icon: "📍" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ],
        homeActions: [
            { label: "Limpezas", entity: "limpeza", icon: "🧹" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Piscina", entity: "piscina", icon: "🏊" },
            { label: "Produtos", entity: "produto", icon: "📦" },
            { label: "Zonas", entity: "zona", icon: "📍" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ]
    },
    RECEP: {
        homeTitle: (u) => `Bem-vindo ${u.username}!`,
        allowedEntities: ["quarto", "marcacao", "faturaRecibo", "cliente", "historico", "informacoes"],
        menu: [
            { label: "Home", route: "/homeUser", icon: "🏠" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Marcações", entity: "marcacao", icon: "📅" },
            { label: "Faturas Recibo", entity: "faturaRecibo", icon: "🧾" },
            { label: "Clientes", entity: "cliente", icon: "👤" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ],
        homeActions: [
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Marcações", entity: "marcacao", icon: "📅" },
            { label: "Faturas Recibo", entity: "faturaRecibo", icon: "🧾" },
            { label: "Clientes", entity: "cliente", icon: "👤" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ]
    },
    HR: {
        homeTitle: (u) => `Bem-vindo ${u.username}!`,
        allowedEntities: ["quarto", "funcionario", "contrato", "vencimento", "historico", "informacoes"
        ],
        menu: [
            { label: "Home", route: "/homeUser", icon: "🏠" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Funcionários", entity: "funcionario", icon: "👥" },
            { label: "Contratos", entity: "contrato", icon: "📄" },
            { label: "Vencimentos", entity: "vencimento", icon: "💶" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ],
        homeActions: [
            { label: "Limpezas", entity: "limpeza" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Funcionários", entity: "funcionario", icon: "👥" },
            { label: "Contratos", entity: "contrato", icon: "📄" },
            { label: "Vencimentos", entity: "vencimento", icon: "💶" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ]
    },
    GERENTE: {
        homeTitle: (u) => `Bem-vindo ${u.username}!`,
        allowedEntities: ["cliente", "quarto", "piscina", "limpeza", "marcacao", "encomenda",
            "manutencao", "catering", "funcionario", "contrato", "colaborador", "produto", "zona",
            "faturaRecibo", "faturaPagamento", "vencimento", "historico", "informacoes"
        ],
        menu: [
            { label: "Home", route: "/homeUser", icon: "🏠" },
            { label: "Clientes", entity: "cliente", icon: "👤" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Piscina", entity: "piscina", icon: "🏊" },
            { label: "Limpezas", entity: "limpeza", icon: "🧹" },
            { label: "Marcações", entity: "marcacao", icon: "📅" },
            { label: "Encomendas", entity: "encomenda", icon: "📦" },
            { label: "Manutenções", entity: "manutencao", icon: "🔧" },
            { label: "Caterings", entity: "catering", icon: "" },
            { label: "Funcionários", entity: "funcionario", icon: "👥" },
            { label: "Contratos", entity: "contrato", icon: "📄" },
            { label: "Colaboradores", entity: "colaborador", icon: "🤝" },
            { label: "Produtos", entity: "produto", icon: "🛒" },
            { label: "Zonas", entity: "zona", icon: "📍" },
            { label: "Faturas Recibo", entity: "faturaRecibo", icon: "🧾" },
            { label: "Faturas Pagamento", entity: "faturaPagamento", icon: "💳" },
            { label: "Vencimentos", entity: "vencimento", icon: "💶" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ],
        homeActions: [
            { label: "Clientes", entity: "cliente", icon: "👤" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Piscina", entity: "piscina", icon: "🏊" },
            { label: "Limpezas", entity: "limpeza", icon: "🧹" },
            { label: "Marcações", entity: "marcacao", icon: "📅" },
            { label: "Encomendas", entity: "encomenda", icon: "📦" },
            { label: "Manutenções", entity: "manutencao", icon: "🔧" },
            { label: "Caterings", entity: "catering", icon: "" },
            { label: "Funcionários", entity: "funcionario", icon: "👥" },
            { label: "Contratos", entity: "contrato", icon: "📄" },
            { label: "Colaboradores", entity: "colaborador", icon: "🤝" },
            { label: "Produtos", entity: "produto", icon: "🛒" },
            { label: "Zonas", entity: "zona", icon: "📍" },
            { label: "Faturas Recibo", entity: "faturaRecibo", icon: "🧾" },
            { label: "Faturas Pagamento", entity: "faturaPagamento", icon: "💳" },
            { label: "Vencimentos", entity: "vencimento", icon: "💶" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ]
    },
    SUPERADMIN: {
        homeTitle: (u) => `Bem-vindo ${u.username}!`,
        allowedEntities: ["user", "cliente", "quarto", "piscina", "limpeza", "marcacao", "encomenda",
            "manutencao", "catering", "funcionario", "contrato", "colaborador", "produto", "zona", "faturaRecibo",
            "faturaPagamento", "cpostal", "tipoFunc", "tipoIVA", "tipoQuarto", "tipoZona", "tipoColab",
            "metodoPagamento", "nacionalidade", "estadoContract", "estadoMarcacao", "estadoServico",
            "vencimento", "historico", "informacoes"
        ],
        menu: [
            { label: "Home", route: "/homeUser", icon: "🏠" },
            { label: "Users", entity: "user", icon: "👤" },
            { label: "Clientes", entity: "cliente", icon: "👤" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Piscina", entity: "piscina", icon: "🏊" },
            { label: "Limpezas", entity: "limpeza", icon: "🧹" },
            { label: "Marcações", entity: "marcacao", icon: "📅" },
            { label: "Encomendas", entity: "encomenda", icon: "📦" },
            { label: "Manutenções", entity: "manutencao", icon: "🔧" },
            { label: "Caterings", entity: "catering", icon: "" },
            { label: "Funcionários", entity: "funcionario", icon: "👥" },
            { label: "Contratos", entity: "contrato", icon: "📄" },
            { label: "Colaboradores", entity: "colaborador", icon: "🤝" },
            { label: "Produtos", entity: "produto", icon: "🛒" },
            { label: "Zonas", entity: "zona", icon: "📍" },
            { label: "Faturas Recibo", entity: "faturaRecibo", icon: "🧾" },
            { label: "Faturas Pagamento", entity: "faturaPagamento", icon: "💳" },
            { label: "Vencimentos", entity: "vencimento", icon: "💶" },
            { label: "Códigos Postais", entity: "cpostal", icon: "📮" },
            { label: "Tipo de Funcionários", entity: "tipoFunc", icon: "🏷️" },
            { label: "Tipos de IVA", entity: "tipoIVA", icon: "💰" },
            { label: "Tipo de Quartos", entity: "tipoQuarto", icon: "🏷️" },
            { label: "Tipo de Zonas", entity: "tipoZona", icon: "🏷️" },
            { label: "Tipos de Colaboradores", entity: "tipoColab", icon: "🏷️" },
            { label: "Método de Pagamentos", entity: "metodoPagamento", icon: "💳" },
            { label: "Nacionalidades", entity: "nacionalidade", icon: "🌍" },
            { label: "Estado de Contratos", entity: "estadoContract", icon: "📊" },
            { label: "Estado de Marcações", entity: "estadoMarcacao", icon: "📊" },
            { label: "Estado de Serviços", entity: "estadoServico", icon: "📊" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ],
        homeActions: [
            { label: "Users", entity: "user", icon: "👤" },
            { label: "Clientes", entity: "cliente", icon: "👤" },
            { label: "Quartos", entity: "quarto", icon: "🛏️" },
            { label: "Piscina", entity: "piscina", icon: "🏊" },
            { label: "Limpezas", entity: "limpeza", icon: "🧹" },
            { label: "Marcações", entity: "marcacao", icon: "📅" },
            { label: "Encomendas", entity: "encomenda", icon: "📦" },
            { label: "Manutenções", entity: "manutencao", icon: "🔧" },
            { label: "Caterings", entity: "catering", icon: "" },
            { label: "Funcionários", entity: "funcionario", icon: "👥" },
            { label: "Contratos", entity: "contrato", icon: "📄" },
            { label: "Colaboradores", entity: "colaborador", icon: "🤝" },
            { label: "Produtos", entity: "produto", icon: "🛒" },
            { label: "Zonas", entity: "zona", icon: "📍" },
            { label: "Faturas Recibo", entity: "faturaRecibo", icon: "🧾" },
            { label: "Faturas Pagamento", entity: "faturaPagamento", icon: "💳" },
            { label: "Vencimentos", entity: "vencimento", icon: "💶" },
            { label: "Códigos Postais", entity: "cpostal", icon: "📮" },
            { label: "Tipo de Funcionários", entity: "tipoFunc", icon: "🏷️" },
            { label: "Tipos de IVA", entity: "tipoIVA", icon: "💰" },
            { label: "Tipo de Quartos", entity: "tipoQuarto", icon: "🏷️" },
            { label: "Tipo de Zonas", entity: "tipoZona", icon: "🏷️" },
            { label: "Tipos de Colaboradores", entity: "tipoColab", icon: "🏷️" },
            { label: "Método de Pagamentos", entity: "metodoPagamento", icon: "💳" },
            { label: "Nacionalidades", entity: "nacionalidade", icon: "🌍" },
            { label: "Estado de Contratos", entity: "estadoContract", icon: "📊" },
            { label: "Estado de Marcações", entity: "estadoMarcacao", icon: "📊" },
            { label: "Estado de Serviços", entity: "estadoServico", icon: "📊" },
            { label: "Histórico", entity: "historico", icon: "🕒" },
            { label: "Informações", entity: "informacoes", icon: "ℹ️" }
        ]
    }
};