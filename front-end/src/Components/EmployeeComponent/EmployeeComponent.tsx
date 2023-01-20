import React from "react";

export const EmployeeComponent: React.FC<any> = (employee: any) => {
  console.log("Hello");
  console.log(employee.accountHolder);
  //this component will render an individual employee, with props data coming from the EmployeeContainerComponent
  return (
    <div className="employee-container">
      <div className="employee-name">
        <h3>{employee.accountHolder}</h3>
      </div>
      <div className="employee-data">
        <p>Quote: {employee.quote}</p>
        <p>Relationship: {employee.relationship}</p>
        <p>Relationship: {employee.price}</p>
      </div>
    </div>
  );
};
