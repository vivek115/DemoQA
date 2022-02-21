package Objects;

public enum StateCity {
    NCR("NCR", 1),
    Uttar_Pradesh("Uttar Pradesh", 2),
    Haryana("Haryana", 3),
    Rajasthan("Rajasthan", 4);
    private String name;
    private int id;

    StateCity(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String ChallengeName() {
        return name;
    }

    public int ChallengeId() {
        return id;
    }

}
