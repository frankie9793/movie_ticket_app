
public class Cinema {
	private int CinemaID;
	private int NoOfSeatEmpty;
	private String CinemaType;
	private int SArraySize = 50;
	private int PArraySize = 20;
	CinemaSeat[] cSeat;

	public Cinema(int CinemaID, String CinemaType) {

		this.CinemaID = CinemaID;
		this.CinemaType = CinemaType;
		if (CinemaType.compareToIgnoreCase("Platinum") == 0) {
			cSeat = new CinemaSeat[PArraySize];
			for (int i = 0; i < cSeat.length; i++) {
				cSeat[i] = new CinemaSeat(i + 1);
			}
			NoOfSeatEmpty = PArraySize;
		} else {
			cSeat = new CinemaSeat[SArraySize];
			for (int i = 0; i < cSeat.length; i++) {
				cSeat[i] = new CinemaSeat(i + 1);
			}
			NoOfSeatEmpty = SArraySize;
		}

	}

	public void ShowNumOfSeatEmpty() {
		System.out.println("Number of Empty Seats are " + NoOfSeatEmpty);
	}

	public int getCinemaID() {
		return CinemaID;
	}

	public void DisplaySeats() {
		if (CinemaType.compareToIgnoreCase("Platinum") == 0) {
			for (int i = 0; i < PArraySize / 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (!cSeat[(i * 4) + j].getSeatBooked())
						System.out.print("[O]");
					else
						System.out.print("[X]");
					if (j == 1)
						System.out.print(" ");
				}
				System.out.println(" ");
			}
		} else {
			for (int i = 0; i < (SArraySize - 20) / 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (!cSeat[(i * 10) + j].getSeatBooked())
						System.out.print("[O]");
					else
						System.out.print("[X]");
					if (j == 1 || j == 7)
						System.out.print(" ");
				}
				System.out.println(" ");
			}
			for (int i = 3; i < SArraySize / 10; i++) {
				for (int j = 0; j < 10; j+=2) {
					if (!cSeat[(i * 10) + j].getSeatBooked())
						System.out.print("[O  O]");
					else
						System.out.print("[X  X]");
					if (j == 0 || j == 6)
						System.out.print(" ");
				}
				System.out.println(" ");
			}
		}
	}

}
