import React from "react";
import css from "./login.module.css";

class Login extends React.Component {
  render() {
    return (
      <div className={css.wrapper}>
        <div className={css.upperDiv}>
          <form className={css.loginForm}>
            <div className={css.spaces}>
              <div className={css.logo} />
              <input
                type="text"
                name="username"
                id="usernameInput"
                className={css.usernameInput}
                placeholder="Username:"
              />
              <br />
              <input
                type="password"
                name="password"
                id="passwordInput"
                className={css.passwordInput}
                placeholder="Password:"
              />
              <div className={css.error401}>
                Username or password is invalid
              </div>
              <div className={css.error403}>Wrong request</div>
              <br />
              <input
                type="button"
                name="submit"
                className={css.loginBtn}
                value="Login"
                onclick="getData()"
              />
            </div>
          </form>
        </div>
      </div>
    );
  }
}

export default Login;
