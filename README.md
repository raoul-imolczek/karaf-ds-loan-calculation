# karaf-ds-loan-calculation
A declarative service wrapping the loan calculation service

## Description

This project consists of two modules:
 - The loan calculation API, declaring an interface for the loan calculation service
 - Its implementation, made available as an OSGI @Component:
 
```java
@Component (
		immediate = true,
		service = LoanCalculationService.class
		)
public class LoanCalculationServiceImpl implements LoanCalculationService {
}
```

## Requirements

Declarative Services require the Service Component Runtime feature to be installed on the karaf server.
Simply install that feature using the following command.
```
feature:install scr
```