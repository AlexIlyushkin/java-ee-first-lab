const FIRST_NAME_FIELD_ID = "firstName";

let firstNameField = document.getElementById(FIRST_NAME_FIELD_ID);
firstNameField.onblur = () => firstNameField.value = 'например, Ванек';

function onFirstNameFieldFocus() {
    let firstNameField = document.getElementById(FIRST_NAME_FIELD_ID);
    firstNameField.value = "";
}

function onFirstNameFieldBlur() {
    let firstNameField = document.getElementById(FIRST_NAME_FIELD_ID);
    firstNameField.value = "например, Иван";
}

function onFirstNameFieldChanged() {
    let firstNameField = document.getElementById(FIRST_NAME_FIELD_ID);
    firstNameField.value = "Изменено, сука!";
}

function foo() {
    alert("Ну, уб твою мать!");
}