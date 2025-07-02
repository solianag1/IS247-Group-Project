# Budget and Savings Manager

## Team members and roles
Soliana Getachew: Project Manager

Kate Abunassar:  Business Analyst

Rereloluwa Akin Babalola: Developer

Muhtada Fadlalla: Quality Assurance 

Ria Guddanti: Developer


## Project Description

Budget and Savings Manager is a personal finance tracker designed to help users take control of their financial habits. 

**The application allows users to:**

-Set a monthly budget

-Track expenses and receive alerts for overspending

-Log income to calculate available earnings

-Set and monitor savings goals

-Estimate how many days it will take to reach a savings goal.

The goal of this project is to make responsible financial habits easier to maintain by providing an interactive command-line interface that supports budgeting, saving, and financial awareness.

**Features**
Set Monthly Budget: Users begin by entering their monthly budget amount.

Track Spending: Users can enter expenses and receive warnings when they are within $50 of their budget or if they exceed it.

Add Income: Users can record income amounts, which updates their available earnings.

View Financial Summary: Users can view a summary that includes original budget, total income, total spent, remaining budget, and remaining earnings.

Savings Goal Estimator: Users can calculate how many days it will take to reach a custom savings goal using daily saving inputs. This is implemented with a recursive method.

Custom Exception Handling: The program uses a custom MyCustomException class to catch invalid operations, like negative inputs or spending more than the available budget.

Organized Structure: Code is modular and organized into separate classes: Main, BudgetManager, SavingsCalculator, and MyCustomException.

Example Menu Output
Choose: [i]ncome  [s]pend  [v]iew summary  [c]alculate savings days  [q]uit
JavaDoc
This project includes comprehensive JavaDoc comments. After generating JavaDocs using IntelliJ or the terminal, documentation can be viewed through GitHub Pages:

### Class Overview
- `Main.java`: Runs the full program
- `BudgetManager.java`: Manages monthly budget and spending alerts
- `FinancialAccount.java`: Handles account balance and transactions
- `GoalTracker.java`: Tracks savings goal progress
- `SavingsCalculator.java`: Uses recursion to calculate savings timeline
- `Trackable.java`: Interface for polymorphism




