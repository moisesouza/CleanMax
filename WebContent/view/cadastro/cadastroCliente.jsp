<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro Cliente</title>

<link rel="stylesheet" type="text/css" href="view/bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="view/bootstrap/js/bootstrap.min.js"></script>
</head>

<body>

	<hr><h3>Cadastro Cliente</h3><hr>


<form action="cadastroCliente" method="post" enctype="multipart/form-data">
<p>
<div class="form-group">
<label for="inputNome">Nome:</label>
<input type="text" id="inputNome" class="form-control" name="nome" style="width: 500px;" maxlength="100" required="required" />
</div>
<p>
</p>
<p>
<div class="form-group">
<label for="inputSenha">Senha:</label>
<input type="text" id="inputSenha" class="form-control" name="senha" style="width: 500px;" maxlength="100" required="required" />
</div>

</p>
<p>
<div class="form-group">
<label for="inputConfirme">Confirme sua Senha:</label>
<input type="text" id="inputConfirme" class="form-control" name="confirmeSenha" style="width: 500px;" maxlength="100" required="required" />
</div>

<div class="form-group">
<label for="inputEmail">Email:</label>
<input type="text" id="inputEmail" class="form-control" name="email" style="width: 500px;" maxlength="100" required="required" />
</div>

<div class="form-group">
<label for="inputDataNascimento">Data de Nascimento:</label>
<input type="text" id="inputDataNascimento" class="form-control" name="dataNascimento" style="width: 500px;" maxlength="100" required="required" />
</div>

<div class="form-group">
<label for="inputCelular">Celular:</label>
<input type="text" id="inputCelular" class="form-control"name="celular" style="width: 500px;" maxlength="100" required="required" />
</div>

<div class="form-group">
<label for="inputTelefone">Telefone:</label>
<input type="text" id="inputTelefone" class="form-control" name="telefone" style="width: 500px;" maxlength="100" required="required" />
</div>

<div class="form-group">
<label for="inputCpf">CPF:</label>
<input type="text" id="inputCpf" class="form-control" name="cpf" style="width: 500px;" maxlength="100" required="required" />
</div>



<a href="listarLivro" class="btn btn-danger" role="button">Cancelar</a> &nbsp;
<button type="reset" class="btn btn-default"> &nbsp; Limpar &nbsp;
</button> &nbsp;
<button type="submit" class="btn btn-primary"> &nbsp; Inserir &nbsp;
</button>


</body>
</html>