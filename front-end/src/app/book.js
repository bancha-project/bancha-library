import React from "react";
import {Datagrid, List, TextField} from "react-admin";

export const BookList = props => (
    <List {...props}>
        <Datagrid>
            <TextField source="id"/>
            <TextField source="title"/>
            <TextField source="author"/>
            <TextField source="summary"/>
            <TextField source="isbn"/>
        </Datagrid>
    </List>
);