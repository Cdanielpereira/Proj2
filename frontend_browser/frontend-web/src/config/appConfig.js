export const appConfig = {

    GUEST: {
        homeTitle: "Bem-vindo ao Goodstay",

        allowedRoutes: ["/home", "/login", "/register", "/quartos", "/informacoes"],

        menu: [
            { label: "Quartos", route: "/quartos" },
            { label: "Informações", route: "/informacoes" }
        ],

        homeActions: [
            { label: "Quartos", route: "/quartos" },
            { label: "Login", route: "/login" }
        ]
    },

    CLIENT: {
        homeTitle: (u) => `Bem-vindo ${u.username}`,

        allowedRoutes: ["/home", "/quartos", "/marcacoes", "/informacoes"],

        menu: [
            { label: "Quartos", route: "/quartos" },
            { label: "Minhas Marcações", route: "/marcacoes" },
            { label: "Informações", route: "/informacoes" }
        ],

        homeActions: [
            { label: "Quartos", route: "/quartos" },
            { label: "Minhas Marcações", route: "/marcacoes" }
        ]
    },

    STAFF: {
        homeTitle: (u) => `Bem-vindo ${u.username}`,

        allowedRoutes: ["/home", "/limpezas", "/quartos", "/informacoes"],

        menu: [
            { label: "Limpezas", route: "/limpezas" },
            { label: "Quartos", route: "/quartos" },
            { label: "Informações", route: "/informacoes" }
        ],

        homeActions: [
            { label: "Limpezas", route: "/limpezas" },
            { label: "Quartos", route: "/quartos" }
        ]
    },

    RECEP: {
        homeTitle: (u) => `Bem-vindo ${u.username}`,

        allowedRoutes: ["/quartos", "/marcacoes", "/faturas", "/clientes"],

        menu: [
            { label: "Quartos", route: "/quartos" },
            { label: "Marcações", route: "/marcacoes" },
            { label: "Faturas", route: "/faturas" },
            { label: "Clientes", route: "/clientes" }
        ],

        homeActions: [
            { label: "Marcações", route: "/marcacoes" },
            { label: "Clientes", route: "/clientes" }
        ]
    },

    HR: {
        homeTitle: (u) => `Bem-vindo ${u.username}`,

        allowedRoutes: ["/funcionarios", "/quartos"],

        menu: [
            { label: "Funcionários", route: "/funcionarios" },
            { label: "Quartos", route: "/quartos" }
        ],

        homeActions: [
            { label: "Funcionários", route: "/funcionarios" }
        ]
    },

    GERENTE: {
        homeTitle: (u) => `Bem-vindo ${u.username}`,

        allowedRoutes: ["*"],

        menu: [
            { label: "Quartos", route: "/quartos" },
            { label: "Marcações", route: "/marcacoes" },
            { label: "Funcionários", route: "/funcionarios" },
            { label: "Colaboradores", route: "/colaboradores" },
            { label: "Clientes", route: "/clientes" },
            { label: "Faturas", route: "/faturas" }
        ],

        homeActions: [
            { label: "Gestão Completa", route: "/clientes" }
        ]
    },

    SUPERADMIN: {
        homeTitle: (u) => `Bem-vindo ${u.username}`,

        allowedRoutes: ["*"],

        menu: [
            { label: "Quartos", route: "/quartos" },
            { label: "Marcações", route: "/marcacoes" },
            { label: "Funcionários", route: "/funcionarios" },
            { label: "Colaboradores", route: "/colaboradores" },
            { label: "Clientes", route: "/clientes" },
            { label: "Faturas", route: "/faturas" },
            { label: "Limpezas", route: "/limpezas" }
        ],

        homeActions: [
            { label: "Admin Panel", route: "/clientes" }
        ]
    }
};