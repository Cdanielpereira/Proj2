const apis = import.meta.glob("../api/*.js", {
    eager: true
});

const buildApi = (entityName) => {
    const module = apis[`../api/${entityName}.js`];

    if (!module) return null;

    return {
        list: Object.values(module).find(
            fn => typeof fn === "function" && fn.name.startsWith("getAll")
        ),

        get: Object.values(module).find(
            fn =>
                typeof fn === "function" &&
                fn.name.startsWith("get") &&
                !fn.name.startsWith("getAll")
        ),

        create: Object.values(module).find(
            fn => typeof fn === "function" && fn.name.startsWith("create")
        ),

        update: Object.values(module).find(
            fn => typeof fn === "function" && fn.name.startsWith("update")
        ),

        delete: Object.values(module).find(
            fn => typeof fn === "function" && fn.name.startsWith("delete")
        )
    };
};

export const entityConfig = {
///////////////////////////------------------1-----------------------////////////////////////////////////
    user: {
        title: "Utilizador",
        api: buildApi("user"),
        table: {
            columns: [
                { field: "username", label: "Username", filter: true },
                { field: "telefone", label: "Telefone" }
            ]
        },
        fields: [
            { name: "username", label: "Username", type: "text", required: true },
            { name: "password", label: "Password", type: "password", required: true },
            { name: "telefone", label: "Telefone", type: "text" }
        ],
        relations: []
    },
///////////////////////////-----------------2-----------------------////////////////////////////////////
    cliente: {
        title: "Cliente",
        api: buildApi("cliente"),
        table: {
            columns: [
                { field: "nome", label: "Nome", filter: true },
                { field: "email", label: "Email" },
                { field: "nif", label: "NIF" }
            ]
        },
        fields: [
            { name: "nif", label: "NIF", type: "number" },
            { name: "nome", label: "Nome", type: "text", required: true },
            { name: "dtNasc", label: "Data Nascimento", type: "date" },
            { name: "rua", label: "Rua", type: "text" },
            { name: "porta", label: "Porta", type: "text" },
            { name: "sexo", label: "Sexo", type: "text" },
            { name: "email", label: "Email", type: "email" },
            { name: "idUser", label: "User", type: "number" },
            { name: "codPostal", label: "Código Postal", type: "text" },
            { name: "idNacional", label: "Nacionalidade", type: "number" }
        ],
        relations: [
            { label: "User", field: "idUser", entity: "user", type: "many-to-one" },
            { label: "Nacionalidade", field: "idNacional", entity: "nacionalidade", type: "many-to-one" }
        ]
    },
///////////////////////////------------------3-----------------------////////////////////////////////////
    funcionario: {
        title: "Funcionário",
        api: buildApi("funcionario"),
        table: {
            columns: [
                { field: "nome", label: "Nome", filter: true },
                { field: "email", label: "Email" },
                { field: "idTipofunc", label: "Tipo" }
            ]
        },
        fields: [
            { name: "nome", label: "Nome", type: "text", required: true },
            { name: "email", label: "Email", type: "email" },
            { name: "iban", label: "IBAN", type: "text" },
            { name: "nif", label: "NIF", type: "number" },
            { name: "rua", label: "Rua", type: "text" },
            { name: "porta", label: "Porta", type: "text" },
            { name: "dtNasc", label: "Data Nascimento", type: "date" },
            { name: "sexo", label: "Sexo", type: "text" },
            { name: "idUser", label: "User", type: "number" },
            { name: "idTipofunc", label: "Tipo Func", type: "number" },
            { name: "codPostal", label: "Código Postal", type: "text" },
            { name: "idNacional", label: "Nacionalidade", type: "number" }
        ],
        relations: [
            { label: "User", field: "idUser", entity: "user", type: "many-to-one" },
            { label: "Tipo", field: "idTipofunc", entity: "tipoFunc", type: "many-to-one" },
            { label: "Nacionalidade", field: "idNacional", entity: "nacionalidade", type: "many-to-one" }
        ]
    },
///////////////////////////------------------4-----------------------////////////////////////////////////
    colaborador: {
        title: "Colaborador",
        api: buildApi("colaborador"),
        table: {
            columns: [
                { field: "nome", label: "Nome" },
                { field: "email", label: "Email" },
                { field: "idTipocolab", label: "Tipo" }
            ]
        },
        fields: [
            { name: "nome", label: "Nome", type: "text" },
            { name: "telefone", label: "Telefone", type: "text" },
            { name: "email", label: "Email", type: "email" },
            { name: "rua", label: "Rua", type: "text" },
            { name: "nporta", label: "Número Porta", type: "text" },
            { name: "codPostal", label: "Código Postal", type: "text" },
            { name: "iban", label: "IBAN", type: "text" },
            { name: "idTipocolab", label: "Tipo", type: "number" }
        ],
        relations: [
            { label: "Tipo", field: "idTipocolab", entity: "tipoColaborador", type: "many-to-one" }
        ]
    },
///////////////////////////------------------5-----------------------////////////////////////////////////
    contrato: {
        title: "Contrato",
        api: buildApi("contrato"),
        table: {
            columns: [
                { field: "salario", label: "Salário" },
                { field: "dtIni", label: "Início" },
                { field: "dtFim", label: "Fim" }
            ]
        },
        fields: [
            { name: "salario", label: "Salário", type: "number" },
            { name: "dtCriado", label: "Criado", type: "date" },
            { name: "dtAssinado", label: "Assinado", type: "date" },
            { name: "dtIni", label: "Início", type: "date" },
            { name: "dtFim", label: "Fim", type: "date" },
            { name: "idFunc", label: "Funcionário", type: "number" },
            { name: "idEstadoc", label: "Estado", type: "number" }
        ],
        relations: [
            { label: "Funcionário", field: "idFunc", entity: "funcionario", type: "many-to-one" },
            { label: "Estado", field: "idEstadoc", entity: "estadoContrato", type: "many-to-one" }
        ]
    },
///////////////////////////-----------------6------------------------////////////////////////////////////
    servico: {
        title: "Serviço",
        api: buildApi("servico"),
        table: {
            columns: [
                { field: "valorpagar", label: "Valor" },
                { field: "dtMarc", label: "Data" },
                { field: "idEstadoser", label: "Estado" }
            ]
        },
        fields: [
            { name: "valorpagar", label: "Valor", type: "number" },
            { name: "dtMarc", label: "Data Marcação", type: "date" },
            { name: "dtRea", label: "Data Realização", type: "date" },
            { name: "idEstadoser", label: "Estado", type: "number" },
            { name: "idColab", label: "Colaborador", type: "number" },
            { name: "idFunc", label: "Funcionário", type: "number" },
            { name: "idFaturap", label: "Fatura Pagamento", type: "number" }
        ],
        relations: [
            { label: "Estado", field: "idEstadoser", entity: "estadoServico", type: "many-to-one" },
            { label: "Colaborador", field: "idColab", entity: "colaborador", type: "many-to-one" },
            { label: "Funcionário", field: "idFunc", entity: "funcionario", type: "many-to-one" },
            { label: "Fatura", field: "idFaturap", entity: "faturaPagamento", type: "many-to-one" }
        ]
    },
///////////////////////////-----------------7------------------------////////////////////////////////////
    manutencao: {
        title: "Manutenção",
        api: buildApi("manutencao"),
        table: {
            columns: [
                { field: "descricao", label: "Descrição" }
            ]
        },
        fields: [
            { name: "descricao", type: "text" },
            { name: "idZona", type: "number" },
            { name: "idiva", type: "number" }
        ],
        relations: [
            { label: "Zona", field: "idZona", entity: "zona", type: "many-to-one" },
            { label: "IVA", field: "idiva", entity: "tipoIva", type: "many-to-one" }
        ]
    },
///////////////////////////-----------------8------------------------////////////////////////////////////
    encomenda: {
        title: "Encomenda",
        api: buildApi("encomenda"),
        table: {
            columns: [
                { field: "valortotal", label: "Total" }
            ]
        },
        fields: [
            { name: "valortotal", type: "number" },
            { name: "idServico", type: "number" }
        ],
        relations: [
            { label: "Serviço", field: "idServico", entity: "servico", type: "many-to-one" }
        ]
    },

///////////////////////////---------------9--------------------------////////////////////////////////////
    catering: {
        title: "Catering",
        api: buildApi("catering"),
        table: {
            columns: [
                { field: "nhospedes", label: "Hóspedes" },
                { field: "precohosp", label: "Preço" }
            ]
        },
        fields: [
            { name: "nhospedes", type: "number" },
            { name: "precohosp", type: "number" },
            { name: "idServico", type: "number" },
            { name: "idiva", type: "number" }
        ],
        relations: [
            { label: "Serviço", field: "idServico", entity: "servico", type: "many-to-one" },
            { label: "IVA", field: "idiva", entity: "tipoIva", type: "many-to-one" }
        ]
    },
///////////////////////////--------------------10---------------------////////////////////////////////////
    marcacao: {
        title: "Marcação",
        api: buildApi("marcacao"),
        table: {
            columns: [
                { field: "dtMarc", label: "Data" },
                { field: "valort", label: "Total" },
                { field: "idCliente", label: "Cliente" }
            ]
        },
        fields: [
            { name: "dtMarc", label: "Data", type: "date" },
            { name: "dtFim", label: "Fim", type: "date" },
            { name: "dtCheckin", label: "Check-in", type: "date" },
            { name: "dtCheckout", label: "Check-out", type: "date" },
            { name: "valort", label: "Total", type: "number" },
            { name: "idEstadom", label: "Estado", type: "number" },
            { name: "idCliente", label: "Cliente", type: "number" },
            { name: "ifFaturar", label: "Fatura", type: "number" }
        ],
        relations: [
            { label: "Estado", field: "idEstadom", entity: "estadoMarcacao", type: "many-to-one" },
            { label: "Cliente", field: "idCliente", entity: "cliente", type: "many-to-one" },
            { label: "Fatura", field: "ifFaturar", entity: "faturaRecibo", type: "many-to-one" }
        ]
    },
///////////////////////////---------------11--------------------------////////////////////////////////////
    reserva: {
        title: "Reserva",
        api: buildApi("reserva"),
        table: {
            columns: [
                { field: "idMarc", label: "Marcação" },
                { field: "nquarto", label: "Quarto" }
            ]
        },
        fields: [
            { name: "idMarc", label: "Marcação", type: "number" },
            { name: "nquarto", label: "Quarto", type: "number" },
            { name: "precoatual", label: "Preço", type: "number" },
            { name: "ivaatual", label: "IVA", type: "number" }
        ],
        relations: [
            { label: "Marcação", field: "idMarc", entity: "marcacao", type: "many-to-one" },
            { label: "Quarto", field: "nquarto", entity: "quarto", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------12----------------------////////////////////////////////////
    quarto: {
        title: "Quarto",
        api: buildApi("quarto"),
        table: {
            columns: [
                { field: "preco", label: "Preço" },
                { field: "idZona", label: "Zona" }
            ]
        },
        fields: [
            { name: "preco", label: "Preço", type: "number" },
            { name: "idZona", label: "Zona", type: "number" },
            { name: "idTipoq", label: "Tipo Quarto", type: "number" },
            { name: "idTipoIVA", label: "IVA", type: "number" }
        ],
        relations: [
            { label: "Zona", field: "idZona", entity: "zona", type: "many-to-one" },
            { label: "Tipo", field: "idTipoq", entity: "tipoQuarto", type: "many-to-one" },
            { label: "IVA", field: "idTipoIVA", entity: "tipoIva", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------13-----------------------////////////////////////////////////
    zona: {
        title: "Zona",
        api: buildApi("zona"),
        table: {
            columns: [
                { field: "andar", label: "Andar" }
            ]
        },
        fields: [
            { name: "andar", label: "Andar", type: "text" },
            { name: "idTipoz", label: "Tipo Zona", type: "number" }
        ],
        relations: [
            { label: "Tipo Zona", field: "idTipoz", entity: "tipoZona", type: "many-to-one" }
        ]
    },
///////////////////////////----------------------14--------------------////////////////////////////////////
    limpeza: {
        title: "Limpeza",
        api: buildApi("limpeza"),
        table: {
            columns: [
                { field: "dtReali", label: "Data" }
            ]
        },
        fields: [
            { name: "idZona", label: "Zona", type: "number" },
            { name: "idFunc", label: "Funcionário", type: "number" },
            { name: "dtReali", label: "Data", type: "date" }
        ],
        relations: [
            { label: "Zona", field: "idZona", entity: "zona", type: "many-to-one" },
            { label: "Funcionário", field: "idFunc", entity: "funcionario", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------15-----------------------////////////////////////////////////
    piscina: {
        title: "Piscina",
        api: buildApi("piscina"),
        table: {
            columns: [
                { field: "ph", label: "PH" },
                { field: "temp", label: "Temperatura" }
            ]
        },
        fields: [
            { name: "ph", label: "PH", type: "number" },
            { name: "temp", label: "Temperatura", type: "number" },
            { name: "volume", label: "Volume", type: "number" },
            { name: "nivelCl", label: "Cloro", type: "number" },
            { name: "idZona", label: "Zona", type: "number" }
        ],
        relations: [
            { label: "Zona", field: "idZona", entity: "zona", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------16-----------------------////////////////////////////////////
    vencimento: {
        title: "Vencimento",
        api: buildApi("vencimento"),
        table: {
            columns: [
                { field: "valor", label: "Valor" },
                { field: "dtPag", label: "Data" }
            ]
        },
        fields: [
            { name: "valor", label: "Valor", type: "number" },
            { name: "dtPag", label: "Pagamento", type: "date" },
            { name: "mes", label: "Mês", type: "date" },
            { name: "premio", label: "Prémio", type: "number" },
            { name: "iban", label: "IBAN", type: "text" },
            { name: "idContrato", label: "Contrato", type: "number" },
            { name: "idMetodo", label: "Método", type: "number" }
        ],
        relations: [
            { label: "Contrato", field: "idContrato", entity: "contrato", type: "many-to-one" },
            { label: "Método", field: "idMetodo", entity: "metodoPagamento", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------17-----------------------////////////////////////////////////
    produto: {
        title: "Produto",
        api: buildApi("produto"),
        table: {
            columns: [
                { field: "nome", label: "Nome" },
                { field: "valor", label: "Valor" }
            ]
        },
        fields: [
            { name: "nome", label: "Nome", type: "text" },
            { name: "valor", label: "Valor", type: "number" },
            { name: "qtdstock", label: "Stock", type: "number" },
            { name: "qtdmin", label: "Stock Mín", type: "number" },
            { name: "idIva", label: "IVA", type: "number" }
        ],
        relations: [
            { label: "IVA", field: "idIva", entity: "tipoIva", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------18-----------------------////////////////////////////////////
    faturaPagamento: {
        title: "Fatura Pagamento",
        api: buildApi("faturaPagamento"),
        table: {
            columns: [
                { field: "valorpago", label: "Valor" },
                { field: "dtPag", label: "Data" }
            ]
        },
        fields: [
            { name: "iban", type: "text" },
            { name: "valorpago", type: "number" },
            { name: "dtPag", type: "date" },
            { name: "idFunc", type: "number" },
            { name: "idMetodo", type: "number" }
        ],
        relations: [
            { label: "Funcionário", field: "idFunc", entity: "funcionario", type: "many-to-one" },
            { label: "Método", field: "idMetodo", entity: "metodoPagamento", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------19-----------------------////////////////////////////////////
    faturaRecibo: {
        title: "Fatura Recibo",
        api: buildApi("faturaRecibo"),
        table: {
            columns: [
                { field: "valor", label: "Valor" },
                { field: "dtPagamento", label: "Data Pagamento" }
            ]
        },
        fields: [
            { name: "valor", type: "number" },
            { name: "dtPagamento", type: "date" },
            { name: "nif", type: "number" },
            { name: "idMetodo", type: "number" }
        ],
        relations: [
            { label: "Método", field: "idMetodo", entity: "metodoPagamento", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------20-----------------------////////////////////////////////////
    nacionalidade: {
        title: "Nacionalidade",
        api: buildApi("nacionalidade"),
        table: {
            columns: [
                { field: "nacionalidade", label: "Nacionalidade", filter: true }
            ]
        },
        fields: [
            { name: "nacionalidade", label: "Nacionalidade", type: "text", required: true }
        ],
        relations: []
    },
///////////////////////////-------------------21-----------------------////////////////////////////////////
    cpostal: {
        title: "Código Postal",
        api: buildApi("cpostal"),
        table: {
            columns: [
                { field: "codPostal", label: "Código" },
                { field: "localidade", label: "Localidade" }
            ]
        },
        fields: [
            { name: "codPostal", type: "text" },
            { name: "localidade", type: "text" }
        ],
        relations: []
    },
///////////////////////////-------------------22-----------------------////////////////////////////////////
    linhaenc: {
        title: "Linha Encomenda",
        api: buildApi("linhaEnc"),
        table: {
            columns: [
                { field: "idEnco", label: "Encomenda" },
                { field: "idProduto", label: "Produto" },
                { field: "qtd", label: "Quantidade" },
                { field: "precoatual", label: "Preço" },
                { field: "ivaatual", label: "IVA" }
            ]
        },
        fields: [
            { name: "idEnco", label: "Encomenda", type: "number", required: true },
            { name: "idProduto", label: "Produto", type: "number", required: true },
            { name: "qtd", label: "Quantidade", type: "number" },
            { name: "precoatual", label: "Preço Atual", type: "number" },
            { name: "ivaatual", label: "IVA Atual", type: "number" }
        ],
        relations: [
            { label: "Encomenda", field: "idEnco", entity: "encomenda", type: "many-to-one" },
            { label: "Produto", field: "idProduto", entity: "produto", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------23-----------------------////////////////////////////////////
    linhamanu: {
        title: "Linha Manutenção",
        api: buildApi("linhaManu"),
        table: {
            columns: [
                { field: "idManu", label: "Manutenção" },
                { field: "idServico", label: "Serviço" },
                { field: "precoatual", label: "Preço" },
                { field: "ivaatual", label: "IVA" }
            ]
        },
        fields: [
            { name: "idManu", label: "Manutenção", type: "number", required: true },
            { name: "idServico", label: "Serviço", type: "number", required: true },
            { name: "precoatual", label: "Preço Atual", type: "number" },
            { name: "ivaatual", label: "IVA Atual", type: "number" }
        ],
        relations: [
            { label: "Manutenção", field: "idManu", entity: "manutencao", type: "many-to-one" },
            { label: "Serviço", field: "idServico", entity: "servico", type: "many-to-one" }
        ]
    },
///////////////////////////-------------------24-----------------------////////////////////////////////////
    metodoPagamento: {
        title: "Método Pagamento",
        api: buildApi("metodoPagamento"),
        table: { columns: [{ field: "metodo", label: "Método" }] },
        fields: [{ name: "metodo", label: "Método", type: "text" }],
        relations: []
    },
///////////////////////////-------------------25-----------------------////////////////////////////////////
    tipoFunc: {
        title: "Tipo Funcionário",
        api: buildApi("tipoFunc"),
        table: {
            columns: [
                { field: "type", label: "Tipo", filter: true }
            ]
        },
        fields: [
            { name: "type", label: "Tipo", type: "text", required: true }
        ],
        relations: []
    },
///////////////////////////-------------------26-----------------------////////////////////////////////////
    tipoZona: {
        title: "Tipo Zona",
        api: buildApi("tipoZona"),
        table: { columns: [{ field: "type", label: "Tipo" }] },
        fields: [{ name: "type", label: "Tipo", type: "text" }],
        relations: []
    },
///////////////////////////-------------------27-----------------------////////////////////////////////////
    tipoQuarto: {
        title: "Tipo Quarto",
        api: buildApi("tipoQuarto"),
        table: { columns: [{ field: "type", label: "Tipo" }] },
        fields: [{ name: "type", label: "Tipo", type: "text" }],
        relations: []
    },
    ///////////////////////////-------------------28-----------------------////////////////////////////////////
    tipoIva: {
        title: "IVA",
        api: buildApi("tipoIVA"),
        table: {
            columns: [
                { field: "type", label: "Tipo" },
                { field: "valor", label: "Valor" }
            ]
        },
        fields: [
            { name: "type", label: "Tipo", type: "text" },
            { name: "valor", label: "Valor", type: "number" }
        ],
        relations: []
    },
///////////////////////////-------------------29-----------------------////////////////////////////////////
    tipoColaborador: {
        title: "Tipo Colaborador",
        api: buildApi("tipoColab"),
        table: {
            columns: [
                { field: "type", label: "Tipo", filter: true }
            ]
        },
        fields: [
            { name: "type", label: "Tipo", type: "text", required: true }
        ],
        relations: []
    },
///////////////////////////-------------------30-----------------------////////////////////////////////////
    estadoServico: {
        title: "Estado Serviço",
        api: buildApi("estadoServico"),
        table: { columns: [{ field: "state", label: "Estado" }] },
        fields: [{ name: "state", label: "Estado", type: "text" }],
        relations: []
    },
///////////////////////////-------------------31-----------------------////////////////////////////////////
    estadoMarcacao: {
        title: "Estado Marcação",
        api: buildApi("estadoMarcacao"),
        table: { columns: [{ field: "state", label: "Estado" }] },
        fields: [{ name: "state", label: "Estado", type: "text" }],
        relations: []
    },
///////////////////////////-------------------32-----------------------////////////////////////////////////
    estadoContrato: {
        title: "Estado Contrato",
        api: buildApi("estadoContract"),
        table: { columns: [{ field: "state", label: "Estado" }] },
        fields: [{ name: "state", label: "Estado", type: "text" }],
        relations: []
    },
};