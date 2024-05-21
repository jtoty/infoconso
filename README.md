# infoconso

## Getting Started

### Installation
```bash
git clone https://github.com/jtoty/infoconso
```

## Run the Application
To run the application, run the following command in a terminal window (in the root) directory:

```bash
mvn spring-boot:run
```

## Test the application
Run the following command from a terminal
```bash
curl http://localhost:8080/billing/{client_reference}/{date}
```
Replace {client_reference}` and  `{date}` with given data (see below). Dates must be in MM-YYYY format.
An example is available below

## Dataset
### Clients reference
Clients references are stored and can be changed in `clients.csv`
#### Pro
- EKW012345678
- EKW165189881
- EKW498499925
- EKW088556678
- EKW045648949
#### Particuliers
- EKW047886977
- EKW043346766
- EKW041446949
- EKW040214694
- EKW044446949
- EKW022561140

### Dates and energy consumption
Availables dates are listed below.
- 12-2023
- 01-2024
- 02-2024
- 03-2024
- 04-2024

Dates and enery consumption are stored and can be changed in `consommations_particuliers.csv` and `consommations_pro.csv`
Each row refers to a client's energy consumption

## Example
### Test command
```bash
curl http://localhost:8080/billing/EKW012345678/01-2024
```
 ### Output result
```bash
google
Siret n°01234567890123
CA 1000000€
Votre consommation pour la période du 01-2024
Electricité : 100kwH à 0.11€ = 11.0€
Gaz : 15kwH à 0.123€ = 1.845€
Total 12.845€
```