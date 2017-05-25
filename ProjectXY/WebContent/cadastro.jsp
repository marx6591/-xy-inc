<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript">
            function validate()
            {
                var a = document.getElementById("a");
                var b = document.getElementById("b");
                var c = document.getElementById("c");
                var valid = true;
                if(a.value.length<=0 || b.value.length<=0 || c.value.length<=0)
                    {
                        alert("Não deixe nenhum campo sem preencher!!!");
                        valid = false;
                    }
                return valid;
            };

        </script>
	</head>
	<body>
		<center>
			<h1>
				<b> Cadastro de Pontos de Interesse </b>
			</h1>
		</center>
		<hr style = "width: 50%">
		<div style = "text-align : center">
			<form action="NewPOI" method="GET" name="f1" onsubmit="return validate();">
				<fieldset style="margin : 0 auto; text=align:left; width: 40%">
					<legend><b> Dados do novo ponto:</b></legend>
					<table border="1" style="margin : 0 auto; text=align:left; width: 70%">
						<tr>
							<th style ="width:30%; text=align:right">Nome:</th>
							<td style ="width:70%"> <input type="text" name="nome" id="a" value="" style = "width: 95%"/></td>
						</tr>
						<tr>
							<th style ="width:30%; text=align:right">Coordenada X:</th>
							<td style ="width:70%"> <input type="number" name="coordenadaX" id="b" style = "width: 95%"/></td>
						</tr>
						<tr>
							<th style ="width:30%; text=align:right">Coordenada Y:</th>
							<td style ="width:70%"> <input type="number" name="coordenadaY" id="c" style = "width: 95%"/></td>
						</tr>
						<tr>
							<td style ="width:30%" colspan="2">
								<input type="submit" value="salvar"/>
								<input type="reset" value="limpar"/>
							</td>
						</tr>
					</table>
				</fieldset>
			</form>		
		</div>
		
	</body>
</html>