package onlineVotingsystem;

public class Candidate {
    private String candidateID;
    private String name;
    private String partyAffiliation;
    private String votingSymbol; // New attribute for voting symbol

    public Candidate(String candidateID, String name, String partyAffiliation, String votingSymbol) {
        this.candidateID = candidateID;
        this.name = name;
        this.partyAffiliation = partyAffiliation;
        this.votingSymbol = votingSymbol;
    }

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPartyAffiliation() {
        return partyAffiliation;
    }

    public void setPartyAffiliation(String partyAffiliation) {
        this.partyAffiliation = partyAffiliation;
    }

    public String getVotingSymbol() {
        return votingSymbol;
    }

    public void setVotingSymbol(String votingSymbol) {
        this.votingSymbol = votingSymbol;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "candidateID='" + candidateID + '\'' +
                ", name='" + name + '\'' +
                ", partyAffiliation='" + partyAffiliation + '\'' +
                ", votingSymbol='" + votingSymbol + '\'' +
                "}\n";
    }
}

