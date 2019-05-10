const express = require('express');
const mysql = require('mysql');

var app = express();
app.use(express.json());

app.post('/login', (req, res, callbackFunction) => {
    callbackFunction = function (status, value) {
        res.status(status).send(value);
    };

    let conn = mysql.createConnection({
       /* host: "localhost",
        user: "root",
        password: "",
        database: "glbank",
        port: "3306" */

        host: "itsovy.sk",
        user: "glbank",
        password: "password",
        database: "glbank",
        port: "3306"
    });

    conn.connect((err) => {
        if (err) console.log(err);

        let sql = "select ide, login, password from loginemp;";

        conn.query(sql, (err, res) => {
            if (err) console.log(err);

            if (res.length == 0) {
                console.log("Database has no users.");
                callbackFunction(401, "Database has no users.");
            }
            else {
                console.log(res);
                callbackFunction(200, res);
            }
            conn.end();
        });
    });
});

app.listen(3300, () => {
    console.log("Port running on 3300.");
});