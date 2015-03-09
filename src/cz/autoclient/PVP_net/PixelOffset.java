package cz.autoclient.PVP_net;


import cz.autoclient.autoclick.ColorPixel;
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jakub
 */
public enum PixelOffset {
    PlayButton_red(0.5282632272641906D, 0.05335365853658536D, new Color(216, 38, 20, 1)),
    PlayButton_cancel(0.5587665322620996D, 0.06253177233521276D, new Color(205, 165, 102, 1)),
    PlayButton_SearchingForGame_Approx (0.42531457289624774D, 0.06710726787193565D, new Color(255, 255, 255, 1)),
    //The button you can press after game mode has been selected
    Play_Solo(0.5306054028901105D, 0.8869954957698297D, new Color(200, 81, 0, 1)),
    LobbyChat(0.495117D, 0.91875D, new Color(255, 255, 255, 1)),
    LobbyChat2(0.5387487383572218D, 0.9184036396562681D, new Color(255, 255, 255, 1)),
    LobbyQuit(0.11646860979241919D, 0.9207317073170731D),
    LobbyChampionSlot1(0.25182702572064036D, 0.26219512195121947D),
    MatchFound(0.495117D, 0.515625D, new Color(255, 255, 255)),
    AcceptButton(0.39004512649241546D, 0.5599898226129755D, new Color(25, 60, 101, 1)),
    //Search champion field in blind queue
    Blind_SearchChampion(0.7103209D, 0.16875D, new Color(255, 255, 255, 1)),
    TeamBuilder_AcceptGroup  (0.36240150633806045D, 0.5802060676136939D, new Color(43, 85, 137, 1)),
    TeamBuilder_CaptainIcon (0.5120583464840514D, 0.17717336270716075D, new Color(56, 97, 99, 1)),
    //The green arrow after the Invited heading on the right
    TeamBuilder_CaptainLobby_Invited (0.9524498123913625D, 0.23029994201505188D, new Color(74, 221, 26, 1)),
    //Vertical distance between slots
    TeamBuilder_CaptainLobby_slot_dist(-1D, 0.11591255359697972D),
    //Top left corner of the first team-builder player slot
    TeamBuilder_CaptainLobby_slot (0.026865151361061504D, 0.4135739654378432D),
    //The first summoner spell location. If this matches, there is NO SUMMONER SPELL => no player
    TeamBuilder_CaptainLobby_slot_summonerSpell (0.09359113104398743D, 0.47763090295196353D, new Color(3, 20, 24, 1)),
    //The green button for accepting player
    TeamBuilder_CaptainLobby_slot_acceptPlayer (0.48441472632969634D, 0.4472D, new Color(29, 164, 53, 1)),
    //Right blue shining border - when player is missing or non-ready
    TeamBuilder_CaptainLobby_slot_blueBorder (0.5469410857838011D, 0.46111466347960717D, new Color(16, 33, 68, 1)),
    //Right blue shining border - when player is waiting for accept, joining or ready - tolerance 30
    TeamBuilder_CaptainLobby_slot_greenBorder(0.5479020083069593D, 0.46124277865367064D, new Color(88, 177, 167, 1)),
    //Marks that the player is ready to play
    TeamBuilder_CaptainLobby_slot_playerReady (0.3489910460131979D, 0.46730888061534553D, new Color(5, 80, 68, 1)),
    //This matches both Kick and no-accept buttons with >10 tolerationnew 
    TeamBuilder_CaptainLobby_slot_kickPlayer (0.5023969319271333D, 0.4607308854697224D, new Color(121, 16, 16, 1)),
    //XXXX (0.09359113104398743D, 0.47763090295196353D+0.5294865190348229D-0.4135739654378432D, new Color(3, 23, 27, 1)),
    TeamBuilder_CaptainReady (0.34619662555792124D, 0.17844432593219253D, new Color(191, 255, 248, 1)),
    TeamBuilder_Chat (0.7713364389662778D, 0.8840874231308464D),
    TeamBuilder_FindAnotherGroup (0.12409443604189642D, 0.9008642400988305D, new Color(45, 88, 142, 1)),
    TeamBuilder_Ready (0.40529677899136995D, 0.8833248405413927D),
    TeamBuilder_Ready_Enabled (0.5196841727335286D, 0.874173849467947D, new Color(42, 97, 100, 1)),
    TeamBuilder_Ready_Pressed (0.5196841727335286D, 0.874173849467947D, new Color(14, 42, 43, 1)),
    TeamBuilder_MatchFound(0.4996663788286509D, 0.49961873194195505D, new Color(255, 255, 255, 1)),
    TeamBuilder_MatchFound2(0.5072922050781281D, 0.5353329777965776D, new Color(255, 255, 255, 1)),
    //Chat betweeen the players invited in a game
    InviteChat (0.4950512695332547D, 0.9208058039244397D, new Color(255, 255, 255, 1)),
    //Start button for a game with invited players
    InviteStart (0.7237508300449225D, 0.9146547965815433D, new Color(204, 110, 22, 1)),
    ;
    
    
    
    public final double x;
    public final double y;
    public final Color color;
    PixelOffset(double x, double y) {
        this.x = x;
        this.y = y;
        color = null;
    }
    PixelOffset(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public ColorPixel offset(double ox, double oy) {
      return new ColorPixel(x+ox, y+oy, color);
    }
    
    
    public double realX(double width) {
        return width*x;   
    }
    public double realY(double height) {
        return height*y;   
    }
    public String toSource() {
      return this.name()+"("
                         +x+"D, "
                         +y+"D"
                         +(color!=null?", new Color("
                           +color.getRed()+", "
                           +color.getGreen()+", "
                           +color.getBlue()+", "
                           +color.getAlpha()
                         +")":"")+")";
    }
}
