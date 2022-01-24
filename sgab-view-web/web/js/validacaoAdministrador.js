function validacaoView(inputEle, regexEle, smallEle, labelEle, inputObrigatorioEle) {
    if(regexEle.test(inputEle.value)) {
        smallEle.classList.remove("invalido");
        labelEle.style.color = "#00a65a";
        inputEle.style.borderColor = "#00a65a";
        inputObrigatorioEle.style.visibility = "hidden";
    }
    else {
        smallEle.classList.add("invalido");
        labelEle.style.color = "#dd4b39";
        inputEle.style.borderColor = "#dd4b39";
        inputObrigatorioEle.style.visibility = "visible";
        inputEle.focus();
    }
}

let loginEle = document.querySelector("#login2");
loginEle.addEventListener("change", () => {

    let smallEle = document.querySelector("#login2 ~ small");
    let labelEle = document.querySelector("label[for=login2]");
    let inputObrigatorioEle = document.querySelector("label[for=login2] .input-obrigatorio");
    
    if(loginEle == null){
        smallEle.classList.add("invalido");
        labelEle.style.color = "#dd4b39";
        loginEle.style.borderColor = "#dd4b39";
        inputObrigatorioEle.style.visibility = "visible";
    } else {
        smallEle.classList.remove("invalido");
        labelEle.style.color = "#00a65a";
        loginEle.style.borderColor = "#00a65a";
        inputObrigatorioEle.style.visibility = "hidden";
    }
});

let cpfEle = document.querySelector("#cpf2");
cpfEle.addEventListener("change", () => {
    let regexEle = /^[0-9]{11}$/;
    let smallEle = document.querySelector("#cpf2 ~ small");
    let labelEle = document.querySelector("label[for=cpf2]");
    let inputObrigatorioEle = document.querySelector("label[for=cpf2] .input-obrigatorio");
    
    validacaoView(cpfEle, regexEle, smallEle, labelEle, inputObrigatorioEle);
});

let nomeEle = document.querySelector("#nome2");
nomeEle.addEventListener("change", () => {
    let regexEle = /^[A-z]+([ ][A-z]+)+/;
    let smallEle = document.querySelector("#nome2 ~ small");
    let labelEle = document.querySelector("label[for=nome2]");
    let inputObrigatorioEle = document.querySelector("label[for=nome2] .input-obrigatorio");

    validacaoView(nomeEle, regexEle, smallEle, labelEle, inputObrigatorioEle);
});

let emailEle = document.querySelector("#email2");
emailEle.addEventListener("change", () => {
    let regexEle = /^[^0-9][A-z0-9_]+([.][A-z0-9_]+)*[@][A-z0-9_]+([.][A-z0-9_]+)*[.][A-z]{2,4}$/;
    let smallEle = document.querySelector("#email2 ~ small");
    let labelEle = document.querySelector("label[for=email2]");
    let inputObrigatorioEle = document.querySelector("label[for=email2] .input-obrigatorio");

    validacaoView(emailEle, regexEle, smallEle, labelEle, inputObrigatorioEle);
});

let senhaEle = document.querySelector("#senha3");
senhaEle.addEventListener("change", () => {
    let regexEle = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/;
    let smallEle = document.querySelector("#senha3 ~ small");
    let labelEle = document.querySelector("label[for=senha3]");
    let inputObrigatorioEle = document.querySelector("label[for=senha3] .input-obrigatorio");

    validacaoView(senhaEle, regexEle, smallEle, labelEle, inputObrigatorioEle);
});

let senha2Ele = document.querySelector("#senha4");
senha2Ele.addEventListener("change", () => {
    let smallEle = document.querySelector("#senha4 ~ small");
    let labelEle = document.querySelector("label[for=senha4]");
    let inputObrigatorioEle = document.querySelector("label[for=senha4] .input-obrigatorio");
    
    if(senha2Ele.value !== senhaEle.value){
        smallEle.classList.add("invalido");
        labelEle.style.color = "#dd4b39";
        senha2Ele.style.borderColor = "#dd4b39";
        inputObrigatorioEle.style.visibility = "visible";
        senha2Ele.focus();
    } else {
        smallEle.classList.remove("invalido");
        labelEle.style.color = "#00a65a";
        senha2Ele.style.borderColor = "#00a65a";
        inputObrigatorioEle.style.visibility = "hidden";
    }
});


