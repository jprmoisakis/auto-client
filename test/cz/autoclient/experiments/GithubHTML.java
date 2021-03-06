/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.autoclient.experiments;

import cz.autoclient.github.interfaces.Release;
import cz.autoclient.github.interfaces.GitHub;
import cz.autoclient.github.interfaces.Repository;
import cz.autoclient.github.interfaces.ReleaseFile;
import cz.autoclient.github.interfaces.Releases;
import cz.autoclient.github.html.*;
import cz.autoclient.github.constructs.*;
import cz.autoclient.github.local.GitHubLocal;
import java.io.File;
/**
 *
 * @author Jakub
 */
public class GithubHTML {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    GitHub git = new GitHubLocal(new File("C:\\MYSELF\\programing\\java\\AutoCall\\fakeupdates"));
    Repository repo = git.getRepository(new BasicRepositoryId("Darker/auto-client"));
    System.out.println("Repo: "+repo.getURL());
    Releases releases = repo.releases();
    if(releases.fetch()) {
      for(Release r: releases) {
        System.out.println("TAG: "+r.tag());
        for(ReleaseFile f: r.downloads()) {
          System.out.println("  File: "+f.name()+" at "+f.downloadUrl()+ " ("+f.size()+" bytes)");
        }
      }
    }
    else {
      System.out.println("Cannot fetch releases.");
    }
  }
  
}
