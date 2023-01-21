import React from "react";

export const EmployeeComponent: React.FC<any> = (employee: any) => {
  console.log("Hello");
  console.log(employee.accountHolder);
  //this component will render an individual employee, with props data coming from the EmployeeContainerComponent
  return (
    <div className="employee-container">
      <div className="employee-name">
        <h3>{employee.accountBalance}</h3>
      </div>
      <div className="employee-data">
        <p>Quote: {employee.accountHolder}</p>
        <p>Relationship: {employee.accountId}</p>
        <p>Relationship: {employee.transactionAmount}</p>
        <p>Relationship: {employee.users}</p>
      </div>
    </div>
  );
};
