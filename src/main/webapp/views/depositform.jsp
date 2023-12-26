<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	 .navbar {
            background-color:black; 
            padding: 10px 0;  
        }

        .navbar a {
            text-decoration: none; 
            color:white; 
            margin-right: 10px;
            }
              </style>
<img src="/images/Kricept1.jpg"  width="1300" height="150">

<body style="background-color: white;">
	
	<center>

<div class="navbar">

<a href="/">Home</a>&nbsp;&nbsp;&nbsp;
    
<a href="/newaccount">New Account</a>&nbsp;&nbsp;&nbsp;
   
<a href="/balanceform">Balance</a>&nbsp;&nbsp;&nbsp;
      
<a href="/depositform">Deposit</a>&nbsp;&nbsp;&nbsp;
<a href="/withdrawform">Withdraw</a>&nbsp;&nbsp;&nbsp;
<a href="/transferform">Transfer</a>&nbsp;&nbsp;&nbsp;
<a href="/closeaccountform">Close A/C</a>&nbsp;&nbsp;&nbsp;
<a href="/about">AboutUs</a>&nbsp;&nbsp;&nbsp;
</center>
</div>
 <center>
<table border="1">

    <h3 style="color:mediumblue;">DEPOSITE FORM</h3></center>
    <form action="deposit">
<center><tr> <td>  Account Number:</td><td><input type="number" name="account_number"><br><br>
	<tr> <td>  Name:</td><td><input type="text" name="name"><br><br>
    <tr> <td>    Password:</td><td><input type="password" name="password"><br><br>
     <tr> <td>   Amount:</td><td><input type="number" name="amount"><br><br>
    
       </td></table>
        <input type="submit" value="Submit">
        <input type="reset" value="Clear">
        </form>

    </center>

</body>
</html>