function calculateBMI() {
    var massRatan = parseInt(document.getElementById("ratanMass").value);
    var heightRatan = parseInt(document.getElementById("ratanHeight").value);
    var massAnu = parseInt(document.getElementById("anuMass").value);
    var heightAnu = parseInt(document.getElementById("anuHeight").value);

    var BMIratan = massRatan / (heightRatan * heightRatan);
    var BMIAnu = massAnu / (heightAnu * heightAnu);

    var resultInput = document.getElementById("bmiResults");
    resultInput.value = "BMIRatan: " + BMIratan.toFixed(2) + "\n";
    resultInput.value += "BMIAnu: " + BMIAnu.toFixed(2) + "\n";

    var RatanHigherBMI = BMIratan > BMIAnu;
    resultInput.value += "BMIratan is higher than BMIAnu: " + RatanHigherBMI + "\n";

    resultInput.value += "\nFizzBuzz JavaScript:\n";
    for (let num = 1; num <= 100; num++) {
        if (num % 15 === 0) {
            resultInput.value += "FizzBuzz: " + num + "\n";
        } else if (num % 3 === 0) {
            resultInput.value += "Fizz: " + num + "\n";
        } else if (num % 5 === 0) {
            resultInput.value += "Buzz: " + num + "\n";
        } else {
            resultInput.value += num + "\n";
        }
    }
}

function convertToCelsius() {
    // Get the value of the input field for Fahrenheit
    const fahrenheit = parseFloat(document.getElementById('farenheitInput').value);
    
    // Convert Fahrenheit to Celsius using the formula (F - 32) * 5/9
    const celsius = (fahrenheit - 32) * 5 / 9;
    
    // Display the result in the output field
    document.getElementById('celciusOutput').value = celsius.toFixed(2);
}



function convertToINR() {
    let rate = 82.89;
    const dollar = parseFloat(document.getElementById('dollarInput').value);
    const inr = dollar * rate;
    document.getElementById('INRoutput').value = inr.toFixed(2);
}

function convertToReverse() {
    const InputString = document.getElementById('string1Input').value;
    const ReversedString = InputString.split('').reverse().join('');
    document.getElementById('stringOutput').value = ReversedString;
}

//Convrting Palindrome
function convertToPalindrome()
{	
	
	const number=parseInt(document.getElementById('NumberInput').value);
	let output=number;
	let rem,rev=0;
	while(output>0){
		rem = output % 10;
		rev = rev * 10 + rem;
		output = Math.floor(output / 10);
		}
	if(number=== rev){
		alert("Palindrome");
	}
	else{
		alert("Not Palindrome");
	}

	
}