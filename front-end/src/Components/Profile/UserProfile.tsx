import React from "react";
import UserP from "./interface";

interface ProfInt {
  user_profile: UserP[];
}

const LoginProfile: React.FC<UserP> = ({ passWord, usrName }: UserP) => {
  return (
    <tr>
      <td>
        <h5>{usrName}</h5>
      </td>

      <td>
        <h5>{passWord}</h5>
      </td>
    </tr>
  );
};

const UserProfile: React.FC<ProfInt> = ({ user_profile }: ProfInt) => {
  return (
    <div>
      <table>
        <tbody>
          <tr className="Table-Header">
            <td>
              <h4>Username</h4>
            </td>
            <td>
              <h4>Password</h4>
            </td>
          </tr>
          {user_profile.map((item) => {
            return (
              <LoginProfile
                usrName={item.usrName}
                passWord={item.passWord}
              ></LoginProfile>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default UserProfile;
