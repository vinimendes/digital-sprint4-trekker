package br.fiap.com.Sprint.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;


public class RoteiroResponseModel {

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("city")
    public String getCity() {
        return this.city; }
    public void setCity(String city) {
        this.city = city; }
    String city;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("foods")
    public ArrayList<Food> getFoods() {
        return this.foods; }
    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods; }
    ArrayList<Food> foods;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("accomodations")
    public ArrayList<Accomodation> getAccomodations() {
        return this.accomodations; }
    public void setAccomodations(ArrayList<Accomodation> accomodations) {
        this.accomodations = accomodations; }
    ArrayList<Accomodation> accomodations;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("turism")
    public ArrayList<String> getTurism() {
        return this.turism; }
    public void setTurism(ArrayList<String> turism) {
        this.turism = turism; }
    ArrayList<String> turism;

    public RoteiroResponseModel() {

    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonProperty("transport")
    public ArrayList<Transport> getTransport() {
        return this.transport; }
    public void setTransport(ArrayList<Transport> transport) {
        this.transport = transport; }
    ArrayList<Transport> transport;

    public class Accomodation{
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonProperty("nome")
        public String getNome() {
            return this.nome; }
        public void setNome(String nome) {
            this.nome = nome; }
        String nome;
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonProperty("preco")
        public double getPreco() {
            return this.preco; }
        public void setPreco(double preco) {
            this.preco = preco; }
        double preco;
    }

    public class Food{

        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonProperty("nome")
        public String getNome() {
            return this.nome; }
        public void setNome(String nome) {
            this.nome = nome; }
        String nome;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonProperty("preco")
        public double getPreco() {
            return this.preco; }
        public void setPreco(double preco) {
            this.preco = preco; }
        double preco;
    }

    public class Transport{

        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonProperty("nome")
        public String getNome() {
            return this.nome; }
        public void setNome(String nome) {
            this.nome = nome; }
        String nome;

        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonProperty("preco")
        public double getPreco() {
            return this.preco; }
        public void setPreco(double preco) {
            this.preco = preco; }
        double preco;
    }
}
