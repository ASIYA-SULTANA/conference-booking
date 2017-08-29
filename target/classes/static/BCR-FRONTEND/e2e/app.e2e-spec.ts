import { BCRFRONTENDPage } from './app.po';

describe('bcr-frontend App', () => {
  let page: BCRFRONTENDPage;

  beforeEach(() => {
    page = new BCRFRONTENDPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!');
  });
});
