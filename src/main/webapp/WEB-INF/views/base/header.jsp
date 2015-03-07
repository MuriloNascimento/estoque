<div class="navbar navbar-inverse">
	<div class="container">
			<div class="navbar-header nav">
				<a class="navbar-brand" href="http://localhost:8080/estoque/">Estoque</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="http://localhost:8080/estoque/usuario/cadastro">Usuario</a></li>
					<li><a href="http://localhost:8080/estoque/setor/cadastro">Setor</a></li>
					<li><a href="http://localhost:8080/estoque/produto/cadastro">Produto</a></li>
				</ul>
				<form class="navbar-form navbar-left" role="search" action="http://localhost:8080/estoque/produto/busca">
			        <div class="form-group">
			          <input name="palavra" type="text" class="form-control" placeholder="Buscar produto">
			        </div>
			        <button type="submit" class="btn btn-default">Submit</button>
			    </form>
			    <div class="navbar-text navbar-right">
			    	<a href="http://localhost:8080/estoque/autenticacao/logout" class="navbar-link">Sair do sistema</a>
			    </div>
			    
			</div>
			
	</div>
</div>