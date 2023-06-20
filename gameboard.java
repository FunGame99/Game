
public class gameboard {

  final int zeroImportance = 0;
  final int lowImportance = 1;
  final int midImportance = 2;
  final int highImportance = 3;
  public int currentImportance = 0;
  public String currentContents;
  
  public gameboard(int importance) {
    this.currentImportance = importance;
    this.currentContents = "";
  }
  
  public void setImportance(int importance) {
    this.currentImportance = importance;
  }
  
  public int getImportance() {
    return this.currentImportance;
  }
  
  public int compareTo(int importance) {
    if(this.currentImportance > importance) {
      return 1;
    }
    else if(this.currentImportance == importance) {
      return 0;
    }
    else {
      return -1;
    }
  }
  
  public void setContents(String contents) {
    this.currentContents = contents;
  }
  
  public String getContents() {
    return this.currentContents;
  }
  
  public boolean isEmpty() {
    if(this.currentContents != "") {
      return false;
    }
    return true;
  }
}
