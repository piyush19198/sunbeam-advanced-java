package pojos;

public class Candidate {
	private int candidateId;
	private String name;
	private String politicalParty;
	private int votes;

	public Candidate(int candidateId, String name, String politicalParty, int votes) {
		super();
		this.candidateId = candidateId;
		this.name = name;
		this.politicalParty = politicalParty;
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Canhdidate [candidateId=" + candidateId + ", name=" + name + ", politicalParty=" + politicalParty
				+ ", votes=" + votes + "]";
	}

	public Candidate() {
		super();
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

}
