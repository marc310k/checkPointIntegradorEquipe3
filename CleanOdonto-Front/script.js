var selectedRow = null

function onFormSubmit() {
        var formData = readFormData();
        if (selectedRow == null)
            insertNewRecord(formData);
        else
            updateRecord(formData);
        resetForm();
}

function readFormData() {
    var formData = {};
    formData["id"] = document.getElementById("id").value;
    formData["nome"] = document.getElementById("nome").value;
    formData["sobrenome"] = document.getElementById("sobrenome").value;
    formData["data"] = document.getElementById("data").value;
    formData["rg"] = document.getElementById("rg").value;
    formData["endereco"] = document.getElementById("endereco").value;

    return formData;
}

function insertNewRecord(data) {
    var table = document.getElementById("pacientesLista").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.id;

    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.nome;

    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.sobrenome;

    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.data;

    cell5 = newRow.insertCell(4);
    cell5.innerHTML = data.rg;

    cell6 = newRow.insertCell(5);
    cell6.innerHTML = data.endereco;

  
    cell7 = newRow.insertCell(6);
    cell7.innerHTML = `<input type="button" id="btn2" onClick="onEdit(this)" value="Edit">
                       <input type="button" id="btn3" onClick="onDelete(this)" value="Delete">`;
}

function resetForm() {
    document.getElementById("id").value = "";
    document.getElementById("nome").value = "";
    document.getElementById("sobrenome").value = "";
    document.getElementById("data").value = "";
    document.getElementById("rg").value = "";
    document.getElementById("endereco").value = "";
    selectedRow = null;
}

function onEdit(td) {
    selectedRow = td.parentElement.parentElement;
    document.getElementById("id").value = selectedRow.cells[0].innerHTML;
    document.getElementById("nome").value = selectedRow.cells[1].innerHTML;
    document.getElementById("sobrenome").value = selectedRow.cells[2].innerHTML;
    document.getElementById("data").value = selectedRow.cells[3].innerHTML;
    document.getElementById("rg").value = selectedRow.cells[4].innerHTML;
    document.getElementById("endereco").value = selectedRow.cells[5].innerHTML;
    
}
function updateRecord(formData) {
    selectedRow.cells[0].innerHTML = formData.id;
    selectedRow.cells[1].innerHTML = formData.nome;
    selectedRow.cells[2].innerHTML = formData.sobrenome;
    selectedRow.cells[3].innerHTML = formData.data;
    selectedRow.cells[4].innerHTML = formData.rg;
    selectedRow.cells[5].innerHTML = formData.endereco;
    
}

function onDelete(td) {
    if (confirm('Você tem certeza que quer deletar o cadastro?')) {
        row = td.parentElement.parentElement;
        document.getElementById("pacientesLista").deleteRow(row.rowIndex);
        resetForm();
    }
}
