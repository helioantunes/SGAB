/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sgab.controller;

import jakarta.servlet.http.HttpServletRequest;
import sgab.model.service.GestaoAcervo;

/**
 *
 * @author HP
 */
public class AcervoController {
    public static String escolherBiblioteca(HttpServletRequest request) {
        String jsp = "";
        try {
            if (true) {
                
            } else {
                String erro = "Nao existe registro!";
                request.setAttribute("erro", erro);
                jsp = "/core/erro.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        return jsp;
    }
}
