import React from "react";
import {Create, Datagrid, Edit, EditButton, List, SimpleForm, TextField, TextInput} from "react-admin";

export const BookList = props => (
    <List {...props}>
        <Datagrid>
            <TextField source="id"/>
            <TextField source="title"/>
            <TextField source="author"/>
            <TextField source="summary"/>
            <TextField source="isbn"/>
            <EditButton/>
        </Datagrid>
    </List>
);

export const BookEdit = props => (
    <Edit {...props}>
        <SimpleForm>
            <TextInput disabled source="id"/>
            <TextInput source="title"/>
            <TextInput source="author"/>
            <TextInput multiline source="summary"/>
            <TextInput source="isbn"/>
        </SimpleForm>
    </Edit>
);

export const BookCreate = props => (
    <Create {...props}>
        <SimpleForm>
            <TextInput source="title"/>
            <TextInput source="author"/>
            <TextInput multiline source="summary"/>
            <TextInput source="isbn"/>
        </SimpleForm>
    </Create>
);