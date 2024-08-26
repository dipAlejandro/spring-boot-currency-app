package com.dahl.currecyapp.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *
 * @author Dahl
 */
public class CurrencyInfo {

    @JsonProperty("nombre")
    private String name;

    @JsonProperty("compra")
    private double purchase;

    @JsonProperty("venta")
    private double sale;

    @JsonProperty("fechaActualizacion")
    private String update;  // Cambiado a String para almacenar la fecha formateada

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm");

    public CurrencyInfo(@JsonProperty("nombre") String name, 
                        @JsonProperty("compra") double purchase, 
                        @JsonProperty("venta") double sale, 
                        @JsonProperty("fechaActualizacion") String update) {
        this.name = name;
        this.purchase = purchase;
        this.sale = sale;
        this.update = update;  // No formatear aquí, almacenar directamente el valor de la API
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPurchase() {
        return purchase;
    }

    public void setPurchase(double purchase) {
        this.purchase = purchase;
    }

    public double getSale() {
        return sale;
    }

    public void setSale(double sale) {
        this.sale = sale;
    }

    public String getUpdate() {
        return update;
    }

    public void setUpdate(String update) {
        this.update = update;
    }

    // Método para formatear el update cuando sea necesario
    public String getFormattedUpdate() {
        try {
            LocalDateTime dateTime = LocalDateTime.parse(update, DateTimeFormatter.ISO_DATE_TIME);
            return dateTime.format(FORMATTER);
        } catch (DateTimeParseException e) {
            return "Fecha no válida";
        }
    }

    @Override
    public String toString() {
        return "CurrencyInfo{" + "name=" + name + ", purchase=" + purchase + ", sale=" + sale + ", update=" + update + '}';
    }
}
