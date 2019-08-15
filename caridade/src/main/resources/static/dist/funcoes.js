$(function(){
    var operacao = "V"; //"A"=Adição; "E"=Edição
    var indice_selecionado = -1; //Índice do item selecionado na lista
    var tbUsuario = localStorage.getItem("tbUsuario");// Recupera os dados armazenados
    tbUsuario = JSON.parse(tbUsuario); // Converte string para objeto
    if(tbUsuario == null) // Caso não haja conteúdo, iniciamos um vetor vazio
    	tbUsuario = [];
});

function Adicionar(){
    var usuario = JSON.stringify({
        nome      : $("#nome").val()
    });
    tbUsuario.push(usuario);
    localStorage.setItem("tbUsuario", JSON.stringify(tbUsuario));
    alert("Registro adicionado.");
    operacao = "A";
    return true;
}