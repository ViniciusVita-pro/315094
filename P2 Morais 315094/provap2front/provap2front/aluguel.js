// Função para realizar o aluguel
function aluguel(clientId, carId) {
    // Substitua pela URL correta de clientes // const clientUrl = `http://127.0.0.1:8080/clients/${idCliente}`; 
    // Substitua pela URL correta de carros // const carUrl = ` 'http://127.0.0.1:8080/cars'${idCarro}`; 

    Promise.all([
        fetch(clientUrl),
        fetch(carUrl)
    ])
    .then(([clientResponse, carResponse]) => {
        if (clientResponse.ok && carResponse.ok) {
           
            const aluguelData = {
                clientId: clientId,
                carId: carId,
                data: new Date().toISOString()
            };

            fetch('http://127.0.0.1:8080/aluguel', {
                method: 'POST',
                body: JSON.stringify(aluguelData),
                headers: { 'Content-type': 'application/json' }
            })
            .then((response) => {
                if (response.ok) {
                    console.log('Aluguel realizado com sucesso!');
                } else {
                    console.log('Erro ao registrar aluguel.');
                }
            })
            .catch((error) => console.log(error));
        } else {
            console.log('Cliente ou carro não encontrado.');
        }
    })
    .catch((error) => console.log(error));
}

function viewAluguel(id) {
   // Substitua pela URL correta de aluguéis const aluguelUrl = `http:///aluguel${id}`; 

    fetch(aluguelUrl)
        .then((response) => {
            if (response.ok) {
                return response.json();
            } else {
                console.log('Aluguel não encontrado.');
            }
        })
        .then((aluguel) => {
            console.log('Detalhes do aluguel:', aluguel);
        })
        .catch((error) => console.log(error));
}

// Função para excluir um aluguel
function deleteAluguel(id) {
    // Substitua pela URL correta de aluguéis const aluguelUrl = `http:///aluguel${id}`; 

    fetch(aluguelUrl, {
        method: 'DELETE'
    })
    .then((response) => {
        if (response.ok) {
            console.log('Aluguel excluído com sucesso!');
            
        } else {
            console.log('Erro ao excluir aluguel.');
        }
    })
    .catch((error) => console.log(error));
}

// Função para atualizar um aluguel
function updateAluguel(id, updatedAluguelData) {
    // Substitua pela URL correta de aluguéisconst aluguelUrl = `http://127.0.0.1:8080/aluguel${id}`; 

    const idCliente = updatedAluguelData.clientId;
    const carId = updatedAluguelData.carId;

    //const clientUrl = `http://127.0.0.1:8080/clientes/${idCliente}`;
    //const carUrl = `http://127.0.0.1:8080/carros/${idCarro}`;

    Promise.all([
        fetch(clientUrl),
        fetch(carUrl)
    ])
    .then(([clientResponse, carResponse]) => {
        if (clientResponse.ok && carResponse.ok) {

            fetch(aluguelUrl, {
                method: 'PUT',
                body: JSON.stringify(updatedAluguelData),
                headers: { 'Content-type': 'application/json' }
            })
            .then((response) => {
                if (response.ok) {
                    console.log('Aluguel atualizado com sucesso!');
                    
                } else {
                    console.log('Erro ao atualizar aluguel.');
                }
            })
            .catch((error) => console.log(error));

        } else {
            console.log('Cliente ou carro não encontrado.');
        }
    })
    .catch((error) => console.log(error));
}