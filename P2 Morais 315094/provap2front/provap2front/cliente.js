// Substitua pela URL correta de cliente const url = 'http:///clients'; 


function viewClients() {
    const tableBody = document.getElementById("table-body");
    fetch(url)
        .then((resp) => resp.json())
        .then((clients) => {
            tableBody.innerHTML = "";
            clients.forEach((client) => {
                const trBody = `
                    <tr>
                        <th scope="row">${client.idCliente}</th>
                        <td>${client.nome}</td>
                        <td>${client.cpf}</td>
                        <td>${client.celular}</td>
                        <td>${client.cnh}</td>
                    </tr>`;
                tableBody.innerHTML += trBody;
            });
        })
        .catch((error) => console.log(error));
}

function addClient() {
    const nome = document.getElementById("clientname").value;
    const cpf = document.getElementById("clientcpf").value;
    const celular = document.getElementById("clientphone").value;
    const cnh = document.getElementById("clientcnh").value;

    const client = {
        nome: nome,
        cpf: cpf,
        celular: celular,
        cnh: cnh,
    };

    fetch(url, {
        method: 'POST',
        body: JSON.stringify(client),
        headers: { 'Content-type': 'application/json' }
    })
    .then((response) => response.json())
    .then((clientjson) => {
        console.log('Cliente adicionado:', clientjson);
        viewClients();
    })
    .catch((error) => console.log(error));
}

function updateClient() {
    const id = document.getElementById("clientid").value;
    const nome = document.getElementById("clientname").value;
    const cpf = document.getElementById("clientcpf").value;
    const celular = document.getElementById("clientphone").value;
    const cnh = document.getElementById("clientcnh").value;

    const client = {
        nome: nome,
        cpf: cpf,
        celular: celular,
        cnh: cnh,
    };

    fetch(`${url}/${id}`, {
        method: 'PUT',
        body: JSON.stringify(client),
        headers: { 'Content-type': 'application/json' }
    })
    .then((response) => response.json())
    .then((clientjson) => {
        console.log('Cliente atualizado:', clientjson);
        viewClients();
    })
    .catch((error) => console.log(error));
}

function deleteClient() {
    const id = document.getElementById("clientid").value;

    fetch(`${url}/${id}`, {
        method: 'DELETE',
    })
    .then((response) => response.json())
    .then((clientjson) => {
        console.log('Cliente excluído:', clientjson);
        viewClients();
    })
    .catch((error) => console.log(error));
}
