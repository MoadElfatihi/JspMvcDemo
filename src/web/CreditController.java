package web;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.CreditBanque;

public class CreditController extends HttpServlet{
	
	private CreditBanque metier;
	
	@Override
	public void init() throws ServletException {
		metier = new CreditBanque();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("model", new CreditModel());
		req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 double montant = Double.parseDouble(req.getParameter("montant"));
		 double taux = Double.parseDouble(req.getParameter("taux"));
		 int duree = Integer.parseInt(req.getParameter("montant"));
		 CreditModel creditModel = new CreditModel();
		 creditModel.setTaux(taux);
		 creditModel.setMontant(montant);
		 creditModel.setDuree(duree);
		 
		 double mensualite = metier.calculerMensualite(montant, duree, taux);
		 creditModel.setMensualite(mensualite);
		 req.setAttribute("model", creditModel);
		 req.getRequestDispatcher("VueCredit.jsp").forward(req, resp);
	}
}
