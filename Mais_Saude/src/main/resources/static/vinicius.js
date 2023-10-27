var cpf = document.querySelector("#cpf");

cpf.addEventListener("blur", function(){//função para bloquear letras//
   if(cpf.value) cpf.value = cpf.value.match(/.{1,3}/g).join(".").replace(/\.(?=[^.]*$)/,"-");
});
function mascaracpf(i){//função para configuar no modo cpf//
   
    var v = i.value;
    
    if(isNaN(v[v.length-1])){ // impede entrar outro caractere que não seja número
       i.value = v.substring(0, v.length-1);
       return;
    }
    
    i.setAttribute("maxlength", "14");
    if (v.length == 3 || v.length == 7) i.value += ".";
    if (v.length == 11) i.value += "-";
 
 }//
// function mascararg(i){//função para configuar no modo rg//
   
    //var v = i.value;
    
   // if(isNaN(v[v.length-1])){ // impede entrar outro caractere que não seja número
       //i.value = v.substring(0, v.length-1);
      // return;
    //}
    
   // i.setAttribute("maxlength", "12");
   // if (v.length == 2)  i.value += ".";
    //if (v.length == 6)  i.value += ".";
//    if (v.length == 10) i.value += "-";
 
// }

 