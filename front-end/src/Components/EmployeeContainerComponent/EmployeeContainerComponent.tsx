import axios from "axios";
import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";

import { EmployeeComponent } from "../EmployeeComponent/EmployeeComponent";

interface IProduct {
  name: string;
  image: string;
  price: number;
}

const EmployeeContainerComponent: React.FC<any> = () => {
  const appState = useSelector<any, any>((state) => state);
  const [error, setError] = useState("");

  let initialProducts: IProduct[] = [];
  const [theThing, setTheThing] = useState("");

  const login = async () => {
    //send an HTTP POST request with axios, and store the response in a variable that we can use

    try {
      const response = await axios.get(
        "http://localhost:5556/data/accounts/accountHolder/james"
      );

      console.log(response.data);
      if (response.status === 200) {
        initialProducts = response.data;

        console.log("response.data[2]");
        console.log(initialProducts);

        let i = 0;
        while (response.data[i] != null) {
          console.log(response.data[i]);
          i++;
        }
      } else {
        console.log("ERROR" + response.status);
      }
    } catch (error) {
      const err = error as Error;
      setError("Login to view your account");
      //navigate("/");
    }
  };

  let [employees, setEmployees] = useState(initialProducts);

  useEffect(() => {
    setEmployees(initialProducts);
  }, []);

  return (
    <div>
      {employees.map((employee: any) => {
        return <EmployeeComponent {...employee} key={employee.userId} />;
      })}

      <button className="login-button" onClick={login}>
        View User Information
      </button>
    </div>
  );
};
export default EmployeeContainerComponent;
