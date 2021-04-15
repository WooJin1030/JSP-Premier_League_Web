<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Footer</title>
<style>
	.footer {
	  margin: 30px 0;
	  padding-top: 50px;
	  border-top: 3px solid rgba(0, 0, 0, 0.1);
	  width: 100%;
	  display: flex;
	  flex-direction: column;
	  justify-content: center;
	  align-items: center;
	  .footer__text {
	    color: rgba(0, 0, 0, 0.2);
	    font-weight: 800;
	    text-transform: uppercase;
	  }
	}

	@media screen and (max-width: 1800px) and (min-height: 680px) and (min-width: 800px){
		.footer {
			position: absolute;
			bottom: 0;
		}
	}
		
</style>
</head>
<body>
	
	<footer class="footer">
		<span class="footer__text">
			EPL &copy;
		</span>
	</footer>
	
</body>
</html>