import { getAllNacionalidades } from "../api/nacionalidade";

export const entityConfig = {

    clientes: {

        title: "Cliente",

        api: {
            list: getAllClientes,
            get: getClienteById,
            create: createCliente,
            update: updateCliente,
            delete: deleteCliente
        },

        fields: [
            {
                name: "nome",
                label: "Nome",
                type: "text",
                required: true
            },

            {
                name: "email",
                label: "Email",
                type: "email"
            },

            {
                name: "dtNasc",
                label: "Data Nascimento",
                type: "date"
            },

            {
                name: "sexo",
                label: "Sexo",
                type: "select",
                options: [
                    { label: "Masculino", value: "M" },
                    { label: "Feminino", value: "F" }
                ]
            },

            {
                name: "idNacional",
                label: "Nacionalidade",
                type: "relation",
                relation: {
                    api: getAllNacionalidades,
                    labelField: "nacionalidade",
                    valueField: "id"
                }
            }
        ]
    }
};