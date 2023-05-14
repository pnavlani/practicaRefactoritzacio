class Adreca {
    private String country;
    private String city;
    private String street;
    private String house;
    private String quarter;

    public Adreca(String country, String city, String street, String house, String quarter) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.house = house;
        this.quarter = quarter;
    }

    public String obtenirAdreçaCompleta() {
        return country +
                ", " +
                city +
                ", " +
                street +
                ", " +
                house +
                " " +
                quarter;

    }
}
